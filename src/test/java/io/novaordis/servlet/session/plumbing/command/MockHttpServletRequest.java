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

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.AsyncContext;
import javax.servlet.DispatcherType;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUpgradeHandler;
import javax.servlet.http.Part;

/**
 * @author Ovidiu Feodorov <ovidiu@novaordis.com>
 * @since 12/7/17
 */
public class MockHttpServletRequest implements HttpServletRequest {

    // Constants -------------------------------------------------------------------------------------------------------

    // Static ----------------------------------------------------------------------------------------------------------

    // Attributes ------------------------------------------------------------------------------------------------------

    // Constructors ----------------------------------------------------------------------------------------------------

    // HttpServletRequest overrides ------------------------------------------------------------------------------------

    @Override
    public String getAuthType() {
        throw new RuntimeException("getAuthType() NOT YET IMPLEMENTED");
    }

    @Override
    public Cookie[] getCookies() {
        throw new RuntimeException("getCookies() NOT YET IMPLEMENTED");
    }

    @Override
    public long getDateHeader(String name) {
        throw new RuntimeException("getDateHeader() NOT YET IMPLEMENTED");
    }

    @Override
    public String getHeader(String name) {
        throw new RuntimeException("getHeader() NOT YET IMPLEMENTED");
    }

    @Override
    public Enumeration<String> getHeaders(String name) {
        throw new RuntimeException("getHeaders() NOT YET IMPLEMENTED");
    }

    @Override
    public Enumeration<String> getHeaderNames() {
        throw new RuntimeException("getHeaderNames() NOT YET IMPLEMENTED");
    }

    @Override
    public int getIntHeader(String name) {
        throw new RuntimeException("getIntHeader() NOT YET IMPLEMENTED");
    }

    @Override
    public String getMethod() {
        throw new RuntimeException("getMethod() NOT YET IMPLEMENTED");
    }

    @Override
    public String getPathInfo() {
        throw new RuntimeException("getPathInfo() NOT YET IMPLEMENTED");
    }

    @Override
    public String getPathTranslated() {
        throw new RuntimeException("getPathTranslated() NOT YET IMPLEMENTED");
    }

    @Override
    public String getContextPath() {
        throw new RuntimeException("getContextPath() NOT YET IMPLEMENTED");
    }

    @Override
    public String getQueryString() {
        throw new RuntimeException("getQueryString() NOT YET IMPLEMENTED");
    }

    @Override
    public String getRemoteUser() {
        throw new RuntimeException("getRemoteUser() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean isUserInRole(String role) {
        throw new RuntimeException("isUserInRole() NOT YET IMPLEMENTED");
    }

    @Override
    public Principal getUserPrincipal() {
        throw new RuntimeException("getUserPrincipal() NOT YET IMPLEMENTED");
    }

    @Override
    public String getRequestedSessionId() {
        throw new RuntimeException("getRequestedSessionId() NOT YET IMPLEMENTED");
    }

    @Override
    public String getRequestURI() {
        throw new RuntimeException("getRequestURI() NOT YET IMPLEMENTED");
    }

    @Override
    public StringBuffer getRequestURL() {
        throw new RuntimeException("getRequestURL() NOT YET IMPLEMENTED");
    }

    @Override
    public String getServletPath() {
        throw new RuntimeException("getServletPath() NOT YET IMPLEMENTED");
    }

    @Override
    public HttpSession getSession(boolean create) {
        throw new RuntimeException("getSession() NOT YET IMPLEMENTED");
    }

    @Override
    public HttpSession getSession() {
        throw new RuntimeException("getSession() NOT YET IMPLEMENTED");
    }

    @Override
    public String changeSessionId() {
        throw new RuntimeException("changeSessionId() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean isRequestedSessionIdValid() {
        throw new RuntimeException("isRequestedSessionIdValid() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean isRequestedSessionIdFromCookie() {
        throw new RuntimeException("isRequestedSessionIdFromCookie() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean isRequestedSessionIdFromURL() {
        throw new RuntimeException("isRequestedSessionIdFromURL() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean isRequestedSessionIdFromUrl() {
        throw new RuntimeException("isRequestedSessionIdFromUrl() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean authenticate(HttpServletResponse response) throws IOException, ServletException {
        throw new RuntimeException("authenticate() NOT YET IMPLEMENTED");
    }

    @Override
    public void login(String username, String password) throws ServletException {
        throw new RuntimeException("login() NOT YET IMPLEMENTED");
    }

    @Override
    public void logout() throws ServletException {
        throw new RuntimeException("logout() NOT YET IMPLEMENTED");
    }

    @Override
    public Collection<Part> getParts() throws IOException, ServletException {
        throw new RuntimeException("getParts() NOT YET IMPLEMENTED");
    }

    @Override
    public Part getPart(String name) throws IOException, ServletException {
        throw new RuntimeException("getPart() NOT YET IMPLEMENTED");
    }

    @Override
    public <T extends HttpUpgradeHandler> T upgrade(Class<T> handlerClass) throws IOException, ServletException {
        throw new RuntimeException("upgrade() NOT YET IMPLEMENTED");
    }

    @Override
    public Object getAttribute(String name) {
        throw new RuntimeException("getAttribute() NOT YET IMPLEMENTED");
    }

    @Override
    public Enumeration<String> getAttributeNames() {
        throw new RuntimeException("getAttributeNames() NOT YET IMPLEMENTED");
    }

    @Override
    public String getCharacterEncoding() {
        throw new RuntimeException("getCharacterEncoding() NOT YET IMPLEMENTED");
    }

    @Override
    public void setCharacterEncoding(String env) throws UnsupportedEncodingException {
        throw new RuntimeException("setCharacterEncoding() NOT YET IMPLEMENTED");
    }

    @Override
    public int getContentLength() {
        throw new RuntimeException("getContentLength() NOT YET IMPLEMENTED");
    }

    @Override
    public long getContentLengthLong() {
        throw new RuntimeException("getContentLengthLong() NOT YET IMPLEMENTED");
    }

    @Override
    public String getContentType() {
        throw new RuntimeException("getContentType() NOT YET IMPLEMENTED");
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        throw new RuntimeException("getInputStream() NOT YET IMPLEMENTED");
    }

    @Override
    public String getParameter(String name) {
        throw new RuntimeException("getParameter() NOT YET IMPLEMENTED");
    }

    @Override
    public Enumeration<String> getParameterNames() {
        throw new RuntimeException("getParameterNames() NOT YET IMPLEMENTED");
    }

    @Override
    public String[] getParameterValues(String name) {
        throw new RuntimeException("getParameterValues() NOT YET IMPLEMENTED");
    }

    @Override
    public Map<String, String[]> getParameterMap() {
        throw new RuntimeException("getParameterMap() NOT YET IMPLEMENTED");
    }

    @Override
    public String getProtocol() {
        throw new RuntimeException("getProtocol() NOT YET IMPLEMENTED");
    }

    @Override
    public String getScheme() {
        throw new RuntimeException("getScheme() NOT YET IMPLEMENTED");
    }

    @Override
    public String getServerName() {
        throw new RuntimeException("getServerName() NOT YET IMPLEMENTED");
    }

    @Override
    public int getServerPort() {
        throw new RuntimeException("getServerPort() NOT YET IMPLEMENTED");
    }

    @Override
    public BufferedReader getReader() throws IOException {
        throw new RuntimeException("getReader() NOT YET IMPLEMENTED");
    }

    @Override
    public String getRemoteAddr() {
        throw new RuntimeException("getRemoteAddr() NOT YET IMPLEMENTED");
    }

    @Override
    public String getRemoteHost() {
        throw new RuntimeException("getRemoteHost() NOT YET IMPLEMENTED");
    }

    @Override
    public void setAttribute(String name, Object o) {
        throw new RuntimeException("setAttribute() NOT YET IMPLEMENTED");
    }

    @Override
    public void removeAttribute(String name) {
        throw new RuntimeException("removeAttribute() NOT YET IMPLEMENTED");
    }

    @Override
    public Locale getLocale() {
        throw new RuntimeException("getLocale() NOT YET IMPLEMENTED");
    }

    @Override
    public Enumeration<Locale> getLocales() {
        throw new RuntimeException("getLocales() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean isSecure() {
        throw new RuntimeException("isSecure() NOT YET IMPLEMENTED");
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        throw new RuntimeException("getRequestDispatcher() NOT YET IMPLEMENTED");
    }

    @Override
    public String getRealPath(String path) {
        throw new RuntimeException("getRealPath() NOT YET IMPLEMENTED");
    }

    @Override
    public int getRemotePort() {
        throw new RuntimeException("getRemotePort() NOT YET IMPLEMENTED");
    }

    @Override
    public String getLocalName() {
        throw new RuntimeException("getLocalName() NOT YET IMPLEMENTED");
    }

    @Override
    public String getLocalAddr() {
        throw new RuntimeException("getLocalAddr() NOT YET IMPLEMENTED");
    }

    @Override
    public int getLocalPort() {
        throw new RuntimeException("getLocalPort() NOT YET IMPLEMENTED");
    }

    @Override
    public ServletContext getServletContext() {
        throw new RuntimeException("getServletContext() NOT YET IMPLEMENTED");
    }

    @Override
    public AsyncContext startAsync() throws IllegalStateException {
        throw new RuntimeException("startAsync() NOT YET IMPLEMENTED");
    }

    @Override
    public AsyncContext startAsync(ServletRequest servletRequest, ServletResponse servletResponse) throws IllegalStateException {
        throw new RuntimeException("startAsync() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean isAsyncStarted() {
        throw new RuntimeException("isAsyncStarted() NOT YET IMPLEMENTED");
    }

    @Override
    public boolean isAsyncSupported() {
        throw new RuntimeException("isAsyncSupported() NOT YET IMPLEMENTED");
    }

    @Override
    public AsyncContext getAsyncContext() {
        throw new RuntimeException("getAsyncContext() NOT YET IMPLEMENTED");
    }

    @Override
    public DispatcherType getDispatcherType() {
        throw new RuntimeException("getDispatcherType() NOT YET IMPLEMENTED");
    }


    // Public ----------------------------------------------------------------------------------------------------------

    // Package protected -----------------------------------------------------------------------------------------------

    // Protected -------------------------------------------------------------------------------------------------------

    // Private ---------------------------------------------------------------------------------------------------------

    // Inner classes ---------------------------------------------------------------------------------------------------

}
