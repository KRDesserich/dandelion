/*
 * [The "BSD licence"]
 * Copyright (c) 2013-2015 Dandelion
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 * 
 * 1. Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * 3. Neither the name of Dandelion nor the names of its contributors
 * may be used to endorse or promote products derived from this software 
 * without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 * IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 * IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 * NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 * THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.github.dandelion.core.i18n;

/**
 * <p>
 * Interface for all MessageResolvers.
 * </p>
 * 
 * <p>
 * A MessageResolver uses the <code>messageKey</code> to lookup in the
 * ResourceBundle. If the <code>defaultValue</code> is present and no message is
 * found for the given key, it will be used as a result.
 * </p>
 * 
 * <p>
 * By default, if the JSTL jar is present in the classpath and no
 * MessageResolver has been configured in the datatables.properties (thanks to
 * the <code>i18n.message.resolver</code> property), the JstlMessageResolver
 * will be used. It is also possible to use different {@link MessageResolver} in
 * different configuration groups.
 * </p>
 * 
 * @author Thibault Duchateau
 * @since 0.11.0
 */
public interface MessageResolver {

   public static final String UNDEFINED_KEY = "???";

   /**
    * Return a localized String.
    * 
    * @param messageKey
    *           The key used to lookup in the configured ResourceBundle.
    * @param defaultValue
    *           The default value to used if no key is found.
    * @param objects
    *           Different objects that may be needed to access the
    *           ResourceBundle, depending on the present JARs.
    * @return a localized String.
    */
   String getResource(String messageKey, String defaultValue, Object... objects);
}