/*
 * JBoss, Home of Professional Open Source.
 * Copyright 2012, Red Hat, Inc., and individual contributors
 * as indicated by the @author tags. See the copyright.txt file in the
 * distribution for a full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */

package org.jboss.as.domain.management.plugin;

/**
 * The interface to be implemented by a Plug-In provider which is providing plug-in implementations for use with the security
 * realms.
 *
 * The load methods are expected to return null where the name is not recognised by this plug-in, if the name is recognised but
 * the provider fails to load the plug-in then optionally a {@link RuntimeException} can be thrown instead.
 *
 * @author <a href="mailto:darran.lofthouse@jboss.com">Darran Lofthouse</a>
 */
public interface PlugInProvider {

    /**
     * Return an authentication plug-in for the specified name or null if this PlugInProvider does not recognise the name.
     *
     * @param name - The name of the desired plug-in.
     * @return The plug-in or null if no plug-in by that name can be obtained by this provider.
     */
    AuthenticationPlugIn<Credential> loadAuthenticationPlugIn(final String name);

    /**
     * Return an authorization plug-in for the specified name or null if this PlugInProvider does not recognise the name.
     *
     * @param name - The name of the desired plug-in.
     * @return The plug-in or null if no plug-in by that name can be obtained by this provider.
     */
    AuthorizationPlugIn loadAuthorizationPlugIn(final String name);

}
