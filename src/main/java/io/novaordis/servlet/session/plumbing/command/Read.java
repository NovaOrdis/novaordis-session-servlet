/*
 * Copyright (c) 2016 Nova Ordis LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.novaordis.servlet.session.plumbing.command;

import io.novaordis.servlet.session.Constants;
import io.novaordis.servlet.session.applicaton.ApplicationType;
import io.novaordis.servlet.session.plumbing.Console;
import io.novaordis.servlet.session.plumbing.Context;
import io.novaordis.servlet.session.plumbing.HttpException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpSession;
import java.util.StringTokenizer;

/**
 * Reads the given session attribute, which is considered to be a String, unless the attribute name is apptype. If the
 * attribute name is apptype, read expects an application type ApplicationType and attempts a typed read invocation
 * into it.
 *
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 6/9/16
 */
public class Read extends CommandBase {

    // Constants -------------------------------------------------------------------------------------------------------

    private static final Logger log = LoggerFactory.getLogger(Read.class);

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    private String attributeName;

    // Constructors ----------------------------------------------------------------------------------------------------

    /**
     * @param argumentPath the path that follows after the "/read"
     */
    public Read(Context context, String argumentPath) throws HttpException {

        super(context);
        extractAttributeName(argumentPath);
    }

    // Command implementation ------------------------------------------------------------------------------------------

    @Override
    public void execute() throws Exception {

        HttpSession session = getContext().getSession();
        Console console = getContext().getConsole();

        if (session == null) {

            console.warn("no active session, can't read. Try establishing a session with /establish-session");
            return;
        }

        String value;

        if (Constants.APP_TYPE_ATTRIBUTE_NAME.equals(attributeName.toLowerCase())) {

            //
            // typed access
            //

            value = typedRead(Constants.APP_TYPE_ATTRIBUTE_NAME, session);
        }
        else {

            //
            // String attribute value
            //

            value = (String)session.getAttribute(attributeName);

        }

        console.info(value);
    }

    // Public ----------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {

        return "read " + attributeName;
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    private void extractAttributeName(String path) throws HttpException {

        StringTokenizer st = new StringTokenizer(path, "/");

        if (!st.hasMoreTokens()) {
            throw new HttpException(400,
                    "invalid read URL: the name of the String session attribute or 'apptype' must follow /read/");
        }

        this.attributeName = st.nextToken();

    }

    private String typedRead(String attributeName, HttpSession session) throws HttpException {

        Object o = session.getAttribute(attributeName);

        if (o == null) {

            throw new HttpException(400, "session does not contain typed state, try /write/" + Constants.APP_TYPE_ATTRIBUTE_NAME + "/&lt;state>");
        }

        ApplicationType at = (ApplicationType)o;

        log.info(at + " acquired from session");

        return at.read();
    }

    // Inner classes ---------------------------------------------------------------------------------------------------

}
