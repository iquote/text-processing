package com.cybozu.labs.langdetect.util;

/*
 * Copyright (C) 2010-2014 Cybozu Labs, 2016 Konstantin Gusarov
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * @author Nakatani Shuyo
 * @author Konstantin Gusarov
 */
public final class NGramTest {
    @Test
    public void testNGram() {
        final NGram ngram = new NGram();
        assertNull(ngram.get(0));
        assertNull(ngram.get(1));
        assertNull(ngram.get(2));
        assertNull(ngram.get(3));
        assertNull(ngram.get(4));
        ngram.addChar(' ');
        assertNull(ngram.get(1));
        assertNull(ngram.get(2));
        assertNull(ngram.get(3));
        ngram.addChar('A');
        assertEquals("A", ngram.get(1));
        assertEquals(" A", ngram.get(2));
        assertNull(ngram.get(3));
        ngram.addChar('\u06cc');
        assertEquals("\u064a", ngram.get(1));
        assertEquals("A\u064a", ngram.get(2));
        assertEquals(" A\u064a", ngram.get(3));
        ngram.addChar('\u1ea0');
        assertEquals("\u1ec3", ngram.get(1));
        assertEquals("\u064a\u1ec3", ngram.get(2));
        assertEquals("A\u064a\u1ec3", ngram.get(3));
        ngram.addChar('\u3044');
        assertEquals("\u3042", ngram.get(1));
        assertEquals("\u1ec3\u3042", ngram.get(2));
        assertEquals("\u064a\u1ec3\u3042", ngram.get(3));

        ngram.addChar('\u30a4');
        assertEquals("\u30a2", ngram.get(1));
        assertEquals("\u3042\u30a2", ngram.get(2));
        assertEquals("\u1ec3\u3042\u30a2", ngram.get(3));
        ngram.addChar('\u3106');
        assertEquals("\u3105", ngram.get(1));
        assertEquals("\u30a2\u3105", ngram.get(2));
        assertEquals("\u3042\u30a2\u3105", ngram.get(3));
        ngram.addChar('\uac01');
        assertEquals("\uac00", ngram.get(1));
        assertEquals("\u3105\uac00", ngram.get(2));
        assertEquals("\u30a2\u3105\uac00", ngram.get(3));
        ngram.addChar('\u2010');
        assertNull(ngram.get(1));
        assertEquals("\uac00 ", ngram.get(2));
        assertEquals("\u3105\uac00 ", ngram.get(3));

        ngram.addChar('a');
        assertEquals("a", ngram.get(1));
        assertEquals(" a", ngram.get(2));
        assertNull(ngram.get(3));
    }

    @Test
    public void testNGram3() {
        final NGram ngram = new NGram();

        ngram.addChar('A');
        assertEquals("A", ngram.get(1));
        assertEquals(" A", ngram.get(2));
        assertNull(ngram.get(3));

        ngram.addChar('1');
        assertNull(ngram.get(1));
        assertEquals("A ", ngram.get(2));
        assertEquals(" A ", ngram.get(3));

        ngram.addChar('B');
        assertEquals("B", ngram.get(1));
        assertEquals(" B", ngram.get(2));
        assertNull(ngram.get(3));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentConstructorInvocation0() {
        TestLangProfile.construct(new int[0]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentConstructorInvocation1() {
        TestLangProfile.construct(new int[1]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentConstructorInvocation2() {
        TestLangProfile.construct(new int[2]);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgumentConstructorInvocation4() {
        TestLangProfile.construct(new int[4]);
    }
}
