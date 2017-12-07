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

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.Locale;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 12/7/17
 */
public class MockHttpServletResponse implements HttpServletResponse {

    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    // HttpServletResponse overrides -----------------------------------------------------------------------------------

    @Override
    public void addCookie(Cookie cookie) {
        throw new RuntimeException("addCookie() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean containsHeader(String name) {
        throw new RuntimeException("containsHeader() NOT YET IMPLEMENTED");
    }

    @Override
    public String encodeURL(String url) {
        throw new RuntimeException("encodeURL() NOT YET IMPLEMENTED");
    }

    @Override
    public String encodeRedirectURL(String url) {
        throw new RuntimeException("encodeRedirectURL() NOT YET IMPLEMENTED");
    }

    @Override
    public String encodeUrl(String url) {
        throw new RuntimeException("encodeUrl() NOT YET IMPLEMENTED");
    }

    @Override
    public String encodeRedirectUrl(String url) {
        throw new RuntimeException("encodeRedirectUrl() NOT YET IMPLEMENTED");
    }

    @Override
    public void sendError(int sc, String msg) throws IOException {
        throw new RuntimeException("sendError() NOT YET IMPLEMENTED");
    }

    @Override
    public void sendError(int sc) throws IOException {
        throw new RuntimeException("sendError() NOT YET IMPLEMENTED");
    }

    @Override
    public void sendRedirect(String location) throws IOException {
        throw new RuntimeException("sendRedirect() NOT YET IMPLEMENTED");
    }

    @Override
    public void setDateHeader(String name, long date) {
        throw new RuntimeException("setDateHeader() NOT YET IMPLEMENTED");
    }

    @Override
    public void addDateHeader(String name, long date) {
        throw new RuntimeException("addDateHeader() NOT YET IMPLEMENTED");
    }

    @Override
    public void setHeader(String name, String value) {
        throw new RuntimeException("setHeader() NOT YET IMPLEMENTED");
    }

    @Override
    public void addHeader(String name, String value) {
        throw new RuntimeException("addHeader() NOT YET IMPLEMENTED");
    }

    @Override
    public void setIntHeader(String name, int value) {
        throw new RuntimeException("setIntHeader() NOT YET IMPLEMENTED");
    }

    @Override
    public void addIntHeader(String name, int value) {
        throw new RuntimeException("addIntHeader() NOT YET IMPLEMENTED");
    }

    @Override
    public void setStatus(int sc) {
        throw new RuntimeException("setStatus() NOT YET IMPLEMENTED");
    }

    @Override
    public void setStatus(int sc, String sm) {
        throw new RuntimeException("setStatus() NOT YET IMPLEMENTED");
    }

    @Override
    public int getStatus() {
        throw new RuntimeException("getStatus() NOT YET IMPLEMENTED");
    }

    @Override
    public String getHeader(String name) {
        throw new RuntimeException("getHeader() NOT YET IMPLEMENTED");
    }

    @Override
    public Collection<String> getHeaders(String name) {
        throw new RuntimeException("getHeaders() NOT YET IMPLEMENTED");
    }

    @Override
    public Collection<String> getHeaderNames() {
        throw new RuntimeException("getHeaderNames() NOT YET IMPLEMENTED");
    }

    @Override
    public String getCharacterEncoding() {
        throw new RuntimeException("getCharacterEncoding() NOT YET IMPLEMENTED");
    }

    @Override
    public String getContentType() {
        throw new RuntimeException("getContentType() NOT YET IMPLEMENTED");
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        throw new RuntimeException("getOutputStream() NOT YET IMPLEMENTED");
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        throw new RuntimeException("getWriter() NOT YET IMPLEMENTED");
    }

    @Override
    public void setCharacterEncoding(String charset) {
        throw new RuntimeException("setCharacterEncoding() NOT YET IMPLEMENTED");
    }

    @Override
    public void setContentLength(int len) {
        throw new RuntimeException("setContentLength() NOT YET IMPLEMENTED");
    }

    @Override
    public void setContentLengthLong(long len) {
        throw new RuntimeException("setContentLengthLong() NOT YET IMPLEMENTED");
    }

    @Override
    public void setContentType(String type) {
        throw new RuntimeException("setContentType() NOT YET IMPLEMENTED");
    }

    @Override
    public void setBufferSize(int size) {
        throw new RuntimeException("setBufferSize() NOT YET IMPLEMENTED");
    }

    @Override
    public int getBufferSize() {
        throw new RuntimeException("getBufferSize() NOT YET IMPLEMENTED");
    }

    @Override
    public void flushBuffer() throws IOException {
        throw new RuntimeException("flushBuffer() NOT YET IMPLEMENTED");
    }

    @Override
    public void resetBuffer() {
        throw new RuntimeException("resetBuffer() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean isCommitted() {
        throw new RuntimeException("isCommitted() NOT YET IMPLEMENTED");
    }

    @Override
    public void reset() {
        throw new RuntimeException("reset() NOT YET IMPLEMENTED");
    }

    @Override
    public void setLocale(Locale loc) {
        throw new RuntimeException("setLocale() NOT YET IMPLEMENTED");
    }

    @Override
    public Locale getLocale() {
        throw new RuntimeException("getLocale() NOT YET IMPLEMENTED");
    }

    // Public ----------------------------------------------------------------------------------------------------------

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
