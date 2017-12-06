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

import io.novaordis.servlet.session.plumbing.Console;
import io.novaordis.servlet.session.plumbing.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 6/9/16
 */
public class InvalidateSession extends CommandBase {

    // Constants -------------------------------------------------------------------------------------------------------

    private static final Logger log = LoggerFactory.getLogger(InvalidateSession.class);

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    /**
     * @param argumentPath the path that follows after the "/establish-session"
     */
    public InvalidateSession(Context context, String argumentPath) {

        super(context, argumentPath);
    }

    // Command implementation ------------------------------------------------------------------------------------------

    @Override
    public void execute() throws Exception {

        //
        // if an existing session was identified, it was injected in the context already
        //

        Context context = getContext();
        Console console = context.getConsole();
        HttpSession session = context.getSession();

        if (session == null) {

            console.warn("no active session, nothing to invalidate");
        }
        else {

            session.invalidate();

            //
            // remove JSESSIONID from browser
            //

            Cookie oldJSessionIdCookie = context.getCookie("JSESSIONID");
            Cookie cookie = new Cookie(oldJSessionIdCookie.getName(), null);
            cookie.setPath(oldJSessionIdCookie.getPath());
            cookie.setMaxAge(0);
            HttpServletResponse response = context.getResponse();
            response.addCookie(cookie);

            console.info("session " + session.getId() + " invalidated");
        }
    }

    // Public ----------------------------------------------------------------------------------------------------------

    @Override
    public String toString() {
        return "invalidate-session";
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
