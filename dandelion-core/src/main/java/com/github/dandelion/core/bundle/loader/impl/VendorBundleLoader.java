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
package com.github.dandelion.core.bundle.loader.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.dandelion.core.bundle.loader.AbstractBundleLoader;
import com.github.dandelion.core.storage.AssetStorageUnit;
import com.github.dandelion.core.storage.BundleStorageUnit;

/**
 * <p>
 * Bundle loader used to load bundles defined by users inside the
 * {@code dandelion/vendor} folder (and all subfolders) of the classpath.
 * </p>
 * 
 * @author Thibault Duchateau
 * @since 0.10.0
 */
public class VendorBundleLoader extends AbstractBundleLoader {

   private static final Logger LOG = LoggerFactory.getLogger(VendorBundleLoader.class);

   public static final String LOADER_NAME = "vendor";
   public static final String SCANNING_PATH = "dandelion/vendor";

   @Override
   public String getName() {
      return LOADER_NAME;
   }

   @Override
   public String getPath() {
      return SCANNING_PATH;
   }

   @Override
   protected Logger getLogger() {
      return LOG;
   }

   @Override
   protected void doCustomBundlePostProcessing(List<BundleStorageUnit> bundles) {
      for (BundleStorageUnit bsu : bundles) {
         for (AssetStorageUnit asu : bsu.getAssetStorageUnits()) {
            asu.setVendor(true);
         }
      }
   }
}
