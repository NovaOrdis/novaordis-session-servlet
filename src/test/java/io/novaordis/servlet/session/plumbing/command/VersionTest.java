/*
 * Copyright (c) 2017 Nova Ordis LLC
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

import java.io.File;
import java.nio.file.Files;

import io.novaordis.servlet.session.plumbing.Context;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 12/7/17
 */
public class VersionTest {

    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    // Public ----------------------------------------------------------------------------------------------------------

    // Tests -----------------------------------------------------------------------------------------------------------

    @org.junit.Test
    public void version() throws Exception {

        MockHttpServletRequest mreq = new MockHttpServletRequest();
        MockHttpServletResponse mresp = new MockHttpServletResponse();

        Context context = new Context(mreq, mresp);

        Version version = new Version(context);

        version.execute();

        File f = new File(System.getProperty("basedir"), "src/main/webapp/WEB-INF/classes/VERSION");

        assertTrue(f.isFile());

        byte[] content = Files.readAllBytes(f.toPath());


        //
        // if we want to make the test fail, enter a random string here
        //

        String expectedVersion = new String(content).trim().replaceAll("version=", "");

        String actualVersion = context.getConsole().getInfos().trim();

        assertEquals(actualVersion, expectedVersion);
    }

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
