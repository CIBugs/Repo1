/*****************************************************************************
 * 
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 * 
 ****************************************************************************/

package org.apache.pdfbox.preflight.font.util;

public class GlyphDetail
{
    private final int code;
    private final GlyphException exception;

    /**
     * @param code character code
     */
    public GlyphDetail(int code)
    {
        this.code = code;
        this.exception = null;
    }

    /**
     * @param code character code
     * @param error glyph exception
     */
    public GlyphDetail(int code, GlyphException error)
    {
        this.code = code;
        this.exception = error;
    }

    public void throwExceptionIfNotValid() throws GlyphException
    {
        if (this.exception != null)
        {
            throw this.exception;
        }
    }

    /**
     * Returns the character code.
     */
    public int getCode()
    {
        return this.code;
    }
}
