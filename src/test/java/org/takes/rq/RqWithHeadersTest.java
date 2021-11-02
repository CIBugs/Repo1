/**
 * The MIT License (MIT)
 *
 * Copyright (c) 2015 Yegor Bugayenko
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included
 * in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NON-INFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
package org.takes.rq;

import com.google.common.base.Joiner;
import java.io.IOException;
import nl.jqno.equalsverifier.EqualsVerifier;
import nl.jqno.equalsverifier.Warning;
import org.hamcrest.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Test;

/**
 * Test case for {@link RqWithHeaders}.
 * @author Igor Khvostenkov (ikhvostenkov@gmail.com)
 * @version $Id: f7655adba80369596b6393068e3aebee6df40d54 $
 * @since 1.0
 * @checkstyle MultipleStringLiteralsCheck (500 lines)
 */
public final class RqWithHeadersTest {
    /**
     * RqWithHeaders can add headers.
     * @throws IOException If some problem inside
     */
    @Test
    public void addsHeadersToRequest() throws IOException {
        MatcherAssert.assertThat(
            new RqPrint(
                new RqWithHeaders(
                    new RqFake(),
                    "TestHeader: someValue",
                    "SomeHeader: testValue"
                )
            ).print(),
            Matchers.startsWith(
                Joiner.on("\r\n").join(
                    "GET /",
                    "Host: www.example.com",
                    "TestHeader: someValue",
                    "SomeHeader: testValue"
                )
            )
        );
    }

    /**
     * Checks RqWithHeaders equals method.
     * @throws Exception If some problem inside
     */
    @Test
    public void equalsAndHashCodeEqualTest() throws Exception {
        EqualsVerifier.forClass(RqWithHeaders.class)
            .suppress(Warning.TRANSIENT_FIELDS)
            .withRedefinedSuperclass()
            .verify();
    }
}
