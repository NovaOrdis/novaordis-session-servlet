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

import javax.servlet.http.HttpSession;
import java.util.StringTokenizer;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 6/9/16
 */
public class Write extends CommandBase {

    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    private String attributeName;
    private String attributeValue;

    // Constructors ----------------------------------------------------------------------------------------------------

    /**
     * @param argumentPath the path that follows after the "/write"
     */
    public Write(Context context, String argumentPath) throws HttpException {

        super(context);
        extractAttributeNameValue(argumentPath);
    }

    // Command implementation ------------------------------------------------------------------------------------------

    @Override
    public void execute() throws Exception {

        HttpSession session = getContext().getSession();
        Console console = getContext().getConsole();

        if (session == null) {

            console.warn("no active session, can't write. Try establishing a session with /establish-session");
            return;

        }

        if (Constants.APP_TYPE_ATTRIBUTE_NAME.equals(attributeName.toLowerCase())) {

            //
            // typed access
            //

            typedWrite(Constants.APP_TYPE_ATTRIBUTE_NAME, attributeValue, session, console);
        }
        else {

            //
            // String attribute value
            //

            session.setAttribute(attributeName, attributeValue);
            console.info(attributeName + "=" + attributeValue + " written into session " + session.getId());
        }
    }

    // Public ----------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {

        return "write " + attributeName + " " + attributeValue;

    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    private void extractAttributeNameValue(String path) throws HttpException {

        StringTokenizer st = new StringTokenizer(path, "/");

        if (!st.hasMoreTokens()) {
            throw new HttpException(400, "invalid write URL: the name of the attribute to be written into the session must follow /write/");
        }

        this.attributeName = st.nextToken();

        if (!st.hasMoreTokens()) {
            throw new HttpException(400, "invalid write URL: the value of the attribute to be written into the session must follow /write/" + attributeName + "/");
        }

        this.attributeValue = st.nextToken();
    }

    private void typedWrite(String attributeName, String attributeValue, HttpSession session, Console console)
            throws HttpException {

        ApplicationType at = (ApplicationType)session.getAttribute(attributeName);

        if (at == null) {

            at = new ApplicationType();
            session.setAttribute(attributeName, at);
            console.info("created new " + at + " and placed it into the session");
        }

        at.write(attributeValue);

        console.info("typed-wrote \"" + attributeValue + "\" into " + at);
    }


    // Inner classes ---------------------------------------------------------------------------------------------------

}
