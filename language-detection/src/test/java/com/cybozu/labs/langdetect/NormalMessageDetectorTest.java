package com.cybozu.labs.langdetect;

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
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Big thanks to {@link https://github.com/mikemccand/chromium-compact-language-detector/blob/master/test.py}
 *
 * @author Konstantin Gusarov
 */
@RunWith(Parameterized.class)
public class NormalMessageDetectorTest {
    @Parameterized.Parameters(name = "{index} - {0}: Detector.detect() = {2}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {"AFRIKAANS", " aam skukuza die naam beteken hy wat skoonvee of hy wat alles onderstebo keer wysig bosveldkampe boskampe is kleiner afgeleë ruskampe wat oor min fasiliteite beskik daar is geen restaurante of winkels nie en slegs oornagbesoekers word toegelaat bateleur", "af"},
                {"ARABIC", "\u0627\u062D\u062A\u064A\u0627\u0644\u064A\u0629 \u0628\u064A\u0639 \u0623\u064A \u062D\u0633\u0627\u0628", "ar"},
                {"BULGARIAN", " а дума попада в състояние на изпитание ключовите думи с предсказана малко под то изискване на страниците за търсене в", "bg"},
                {"BENGALI", "\u0997\u09CD\u09AF\u09BE\u09B2\u09BE\u09B0\u09BF\u09B0 \u09E9\u09EE \u09AC\u099B\u09B0 \u09AA\u09C2\u09B0\u09CD\u09A4\u09BF\u09A4\u09C7 \u09AE\u09C2\u09B2\u09CD\u09AF\u099B\u09BE\u09DC \u0985\u09B0\u09CD\u09A5\u09A8\u09C0\u09A4\u09BF \u09AC\u09BF\u098F\u09A8\u09AA\u09BF\u09B0 \u0993\u09DF\u09BE\u0995 \u0986\u0989\u099F \u09A4\u09AA\u09A8 \u099A\u09CC\u09A7\u09C1\u09B0\u09C0 \u09B9\u09BE\u09B0\u09AC\u09BE\u09B2 \u0985\u09CD\u09AF\u09BE\u09B8\u09CB\u09B8\u09BF\u09DF\u09C7\u09B6\u09A8\u09C7\u09B0 \u09B8\u09AD\u09BE\u09AA\u09A4\u09BF \u0986\u09A8\u09CD\u09A4\u09B0\u09CD\u099C\u09BE\u09A4\u09BF\u0995 \u09AA\u09B0\u09BE\u09AE\u09B0\u09CD\u09B6\u0995 \u09AC\u09CB\u09B0\u09CD\u09A1 \u09A6\u09BF\u09DF\u09C7 \u09B6\u09B0\u09BF\u09DF\u09BE\u09B9\u09CD \u0987\u09A8\u09A8\u09CD\u09A1\u09C7\u0995\u09CD\u09B8 \u0995\u09B0\u09AC\u09C7 \u09B8\u09BF\u098F\u09B8\u0987 \u09AE\u09BE\u09B2\u09BF\u0995\u09AA\u0995\u09CD\u09B7\u09C7\u09B0 \u0995\u09BE\u09A8\u09CD\u09A8\u09BE, \u09B6\u09CD\u09B0\u09AE\u09BF\u0995\u09C7\u09B0 \u0985\u09A8\u09BF\u09B6\u09CD\u099A\u09DF\u09A4\u09BE \u09AE\u09A4\u09BF\u099D\u09BF\u09B2\u09C7 \u09B8\u09AE\u09BE\u09AC\u09C7\u09B6 \u09A8\u09BF\u09B7\u09BF\u09A6\u09CD\u09A7: \u098F\u09AB\u09AC\u09BF\u09B8\u09BF\u09B8\u09BF\u0986\u0987\u09DF\u09C7\u09B0 \u09A7\u09A8\u09CD\u09AF\u09AC\u09BE\u09A6 \u09AC\u09BF\u09A8\u09CB\u09A6\u09A8 \u09AC\u09BF\u09B6\u09C7\u09B7 \u09AA\u09CD\u09B0\u09A4\u09BF\u09AC\u09C7\u09A6\u09A8 \u09AC\u09BE\u0982\u09B2\u09BE\u09B2\u09BF\u0982\u0995\u09C7\u09B0 \u0997\u09CD\u09B0\u09CD\u09AF\u09BE\u09A8\u09CD\u09A1\u09AE\u09BE\u09B8\u09CD\u099F\u09BE\u09B0 \u09B8\u09BF\u099C\u09A8-\u09E9 \u09AC\u09CD\u09B0\u09BE\u099C\u09BF\u09B2\u09C7 \u09AC\u09BF\u09B6\u09CD\u09AC\u0995\u09BE\u09AA \u09AB\u09C1\u099F\u09AC\u09B2 \u0986\u09DF\u09CB\u099C\u09A8\u09AC\u09BF\u09B0\u09CB\u09A7\u09C0 \u09AC\u09BF\u0995\u09CD\u09B7\u09CB\u09AD \u09A6\u09C7\u09B6\u09C7\u09B0 \u09A8\u09BF\u09B0\u09BE\u09AA\u09A4\u09CD\u09A4\u09BE\u09B0  \u099A\u09C7\u09DF\u09C7 \u0985\u09A8\u09C7\u0995 \u09AC\u09C7\u09B6\u09BF \u09B8\u099A\u09C7\u09A4\u09A8 \u0964 \u09AA\u09CD\u09B0\u09BE\u09B0\u09CD\u09A5\u09C0\u09A6\u09C7\u09B0 \u09A6\u0995\u09CD\u09B7\u09A4\u09BE  \u0993 \u09AF\u09C7\u09BE\u0997\u09CD\u09AF\u09A4\u09BE\u09B0 \u09AA\u09BE\u09B6\u09BE\u09AA\u09BE\u09B6\u09BF \u09A4\u09BE\u09B0\u09BE \u099C\u09BE\u09A4\u09C0\u09DF \u0987\u09B8\u09CD\u09AF\u09C1\u0997\u09C1\u09B2\u09CB\u09A4\u09C7 \u09AA\u09CD\u09B0\u09BE\u09A7\u09BE\u09A8\u09CD\u09AF \u09A6\u09BF\u09DF\u09C7\u099B\u09C7\u09A8 \u0964 \u201D \u09AA\u09BE\u0981\u099A\u099F\u09BF \u09B8\u09BF\u099F\u09BF\u09A4\u09C7 \u09E8\u09E6 \u09B2\u09BE\u0996 \u09AD\u09CB\u099F\u09BE\u09B0\u09A6\u09C7\u09B0 \u09A6\u09BF\u09DF\u09C7 \u099C\u09BE\u09A4\u09C0\u09DF \u09A8\u09BF\u09B0\u09CD\u09AC\u09BE\u099A\u09A8\u09C7 \u09EE \u0995\u09CB\u099F\u09BF \u09AD\u09CB\u099F\u09BE\u09B0\u09A6\u09C7\u09B0 \u09B8\u0999\u09CD\u0997\u09C7 \u09A4\u09C1\u09B2\u09A8\u09BE \u0995\u09B0\u09BE \u09AF\u09BE\u09AC\u09C7 \u0995\u09BF \u098F\u0995\u099C\u09A8 \u09A6\u09B0\u09CD\u09B6\u0995\u09C7\u09B0 \u098F\u09AE\u09A8 \u09AA\u09CD\u09B0\u09B6\u09CD\u09A8\u09C7 \u099C\u09AC\u09BE\u09AC\u09C7 \u0986\u09AC\u09CD\u09A6\u09C1\u09B2\u09CD\u09B2\u09BE\u09B9 \u0986\u09B2 \u09A8\u09C7\u09BE\u09AE\u09BE\u09A8 \u09AC\u09B2\u09C7\u09A8 , \u201C \u098F\u0987 \u09AA\u09BE\u0981\u099A\u099F\u09BF \u09B8\u09BF\u099F\u09BF \u0995\u09B0\u09CD\u09AA\u09CB\u09B0\u09C7\u09B6\u09A8 \u09A8\u09BF\u09B0\u09CD\u09AC\u09BE\u099A\u09A8 \u09A6\u09C7\u09B6\u09C7\u09B0 \u09AA\u09BE\u0981\u099A\u099F\u09BF \u09AC\u09DC \u09AC\u09BF\u09AD\u09BE\u0997\u09C7\u09B0 \u09AA\u09CD\u09B0\u09A4\u09BF\u09A8\u09BF\u09A7\u09BF\u09A4\u09CD\u09AC \u0995\u09B0\u099B\u09C7 \u0964 \u098F\u099B\u09BE\u09DC\u09BE \u098F\u0996\u09BE\u09A8\u0995\u09BE\u09B0 \u09AD\u09CB\u099F\u09BE\u09B0 \u09B0\u09BE \u09B8\u09AC\u09BE\u0987 \u09B8\u099A\u09C7\u09A4\u09A8 \u0964 \u09A4\u09BE\u09B0\u09BE", "bn"},
                {"CZECH", " a akci opakujte film uložen vykreslit gmail tokio smazat obsah adresáře nelze načíst systémový profil jednotky smoot okud používáte pro určení polokoule značky z západ nebo v východ používejte nezáporné hodnoty zeměpisné délky nelze", "cs"},
                {"DANISH", " a z tallene og punktummer der er tilladte log ud angiv den ønskede adgangskode igen november gem personlige oplysninger kontrolspørgsmål det sidste tegn i dit brugernavn skal være et bogstav a z eller tal skriv de tegn du kan se i billedet nedenfor", "da"},
                {"GERMAN", " abschnitt ordner aktivieren werden die ordnereinstellungen im farbabschnitt deaktiviert öchten sie wirklich fortfahren eldtypen angeben optional n diesem schritt geben sie für jedesfeld aus dem datenset den typ an ieser schritt ist optional eldtypen", "de"},
                {"GREEK", " \u03AE \u03B1\u03C1\u03BD\u03B7\u03C4\u03B9\u03BA\u03AE \u03B1\u03BD\u03B1\u03B6\u03AE\u03C4\u03B7\u03C3\u03B7 \u03BB\u03AD\u03BE\u03B7\u03C2 \u03BA\u03BB\u03B5\u03B9\u03B4\u03B9\u03BF\u03CD \u03BA\u03B1\u03C4\u03B1\u03C3\u03C4\u03AE\u03C3\u03C4\u03B5 \u03C4\u03B9\u03C2 \u03BC\u03B5\u03BC\u03BF\u03BD\u03C9\u03BC\u03AD\u03BD\u03B5\u03C2 \u03BB\u03AD\u03BE\u03B5\u03B9\u03C2 \u03BA\u03BB\u03B5\u03B9\u03B4\u03B9\u03AC \u03C0\u03B5\u03C1\u03B9\u03C3\u03C3\u03CC\u03C4\u03B5\u03C1\u03BF \u03C3\u03C4\u03BF\u03C7\u03BF\u03B8\u03B5\u03C4\u03B7\u03BC\u03AD\u03BD\u03B5\u03C2 \u03BC\u03B5 \u03C4\u03B7 \u03BC\u03B5\u03C4\u03B1\u03C4\u03C1\u03BF\u03C0\u03AE \u03C4\u03BF\u03C5\u03C2 \u03C3\u03B5", "el"},
                {"ENGLISH", "confiscation of goods is assigned as the penalty part most of the courts consist of members and when it is necessary to bring public cases before a jury of members two courts combine for the purpose the most important cases of all are brought jurors or", "en"},
                {"ENGLISH", " a backup credit card by visiting your billing preferences page or visit the adwords help centre for more details https adwords google com support bin answer py answer hl en we were unable to process the payment of for your outstanding google adwords", "en"},
                {"ENGLISH", "Forty good bytes followed by bad UTF-8: \u00C0\u00A9 and then good again.", "en"},
                {"SPANISH", " a continuación haz clic en el botón obtener ruta también puedes desplazarte hasta el final de la página para cambiar tus opciones de búsqueda gráfico y detalles ésta es una lista de los vídeos que te recomendamos nuestras recomendaciones se basan", "es"},
                {"ESTONIAN", " a niipea kui sinu maksimaalne igakuine krediidi limiit on meie poolt heaks kiidetud on sinu kohustuseks see krediidilimiit", "et"},
                {"PERSIAN", " \u0622\u0628 \u062E\u0648\u0631\u062F\u0646 \u0639\u062C\u0644\u0647 \u0645\u06CC \u06A9\u0631\u062F\u0646\u062F \u0628\u0647 \u062C\u0627\u06CC \u0628\u0627\u0632 \u06CC \u06A9\u062A\u06A9 \u06A9\u0627\u0631\u06CC \u0645\u06CC \u06A9\u0631\u062F\u0646\u062F \u0648 \u0647\u0645\u0647 \u0686\u064A\u0632 \u0645\u062B\u0644 \u0642\u0628\u0644 \u0628\u0648\u062F \u0641\u0642\u0637 \u0645\u0646 \u0645\u0627\u0646\u062F\u0645 \u0648 \u064A\u06A9 \u062F\u0646\u064A\u0627 \u062D\u0631\u0641 \u0648 \u0627\u0646\u062A\u0638\u0627\u0631 \u062A\u0627 \u0639\u0627\u0642\u0628\u062A \u0631\u0633\u064A\u062F \u0627\u062D\u0636\u0627\u0631\u064A\u0647 \u06CC \u0627\u06CC \u0628\u0627", "fa"},
                {"FINNISH", " a joilla olet käynyt tämä kerro meille kuka ä olet ei tunnistettavia käyttötietoja kuten virheraportteja käytetään google desktopin parantamiseen etsi näyttää mukautettuja uutisia google desktop keskivaihto leikkaa voit kaksoisnapsauttaa", "fi"},
                {"FRENCH", "France is the largest country in Western Europe and the third-largest in Europe as a whole. A accès aux chiens et aux frontaux qui lui ont été il peut consulter et modifier ses collections et exporter Cet article concerne le pays européen aujourd’hui appelé République française. Pour d’autres usages du nom France, Pour une aide rapide et effective, veuiller trouver votre aide dans le menu ci-dessus. Motoring events began soon after the construction of the first successful gasoline-fueled automobiles. The quick brown fox jumped over the lazy dog", "fr"},
                {"FRENCH", " a accès aux collections et aux frontaux qui lui ont été attribués il peut consulter et modifier ses collections et exporter des configurations de collection toutefois il ne peut pas créer ni supprimer des collections enfin il a accès aux fonctions", "fr"},
                {"GUJARATI", " \u0A86\u0AA8\u0ABE \u0AAA\u0AB0\u0ABF\u0AA3\u0ABE\u0AAE \u0AAA\u0ACD\u0AB0\u0AAE\u0ABE\u0AA3\u0AB8\u0AB0 \u0AAB\u0ACB\u0AA8\u0ACD\u0A9F \u0A85\u0AB5\u0AA4\u0AB0\u0AA3 \u0A9A\u0ABF\u0AA8\u0ACD\u0AB9\u0AB5\u0ABE\u0AB3\u0ABE \u0AAA\u0ABE\u0AA0\u0AA8\u0AC7 \u0A9B\u0AC1\u0AAA\u0ABE\u0AB5\u0ACB \u0AAC\u0AA7\u0ABE \u0AB8\u0AAE\u0AC2\u0AB9\u0ACB \u0AB6\u0ACB\u0AA7\u0ABE\u0AAF\u0ABE \u0AB9\u0ABE\u0AB2\u0AA8\u0ACB \u0A9C \u0AB8\u0A82\u0AA6\u0AC7\u0AB6 \u0AB5\u0ABF\u0AB7\u0AAF\u0AA8\u0AC0", "gu"},
                {"HEBREW", " \u05D0\u05D5 \u05DC\u05E2\u05E8\u05D5\u05DA \u05D0\u05EA \u05D4\u05E2\u05D3\u05E4\u05D5\u05EA \u05D4\u05D4\u05E4\u05E6\u05D4 \u05D0\u05E0\u05D0 \u05E2\u05E7\u05D5\u05D1 \u05D0\u05D7\u05E8\u05D9 \u05D4\u05E9\u05DC\u05D1\u05D9\u05DD \u05D4\u05D1\u05D0\u05D9\u05DD \u05DB\u05E0\u05E1 \u05DC\u05D7\u05E9\u05D1\u05D5\u05DF \u05D4\u05D0\u05D9\u05E9\u05D9 \u05E9\u05DC\u05DA \u05D1", "he"},
                {"HINDI", " \u0902 \u0910\u0921\u0935\u0930\u094D\u0921\u094D\u0938 \u0935\u093F\u091C\u094D\u091E\u093E\u092A\u0928\u094B\u0902 \u0915\u0947 \u0905\u0928\u0941\u092D\u0935 \u092A\u0930 \u0906\u0927\u093E\u0930\u093F\u0924 \u0939\u0948\u0902 \u0914\u0930 \u0907\u0928\u0915\u0940 \u092E\u0926\u0926 \u0938\u0947 \u0906\u092A\u0915\u094B \u0905\u092A\u0928\u0947 \u0935\u093F\u091C\u094D\u091E\u093E\u092A\u0928\u094B\u0902 \u0915\u093E \u0905\u0927\u093F\u0915\u0924\u092E \u0932\u093E\u092D", "hi"},
                {"CROATIAN", "Posljednja dva vladara su Kijaksar (Κυαξαρης; 625-585 prije Krista), fraortov sin koji će proširiti teritorij Medije i Astijag. Kijaksar je imao kćer ili unuku koja se zvala Amitis a postala je ženom Nabukodonosora II. kojoj je ovaj izgradio Viseće vrtove Babilona. Kijaksar je modernizirao svoju vojsku i uništio Ninivu 612. prije Krista. Naslijedio ga je njegov sin, posljednji medijski kralj, Astijag, kojega je detronizirao (srušio sa vlasti) njegov unuk Kir Veliki. Zemljom su zavladali Perzijanci.", "hr"},
                {"HUNGARIAN", " a felhasználóim a google azonosító szöveget ikor látják a felhasználóim a google azonosító szöveget felhasználók a google azonosító szöveget fogják látni minden tranzakció után ha a vásárlását regisztrációját oldalunk", "hu"},
                {"INDONESIAN", "berdiri setelah pengurusnya yang berusia 83 tahun, Fayzrahman Satarov, mendeklarasikan diri sebagai nabi dan rumahnya sebagai negara Islam Satarov digambarkan sebagai mantan ulama Islam  tahun 1970-an. Pengikutnya didorong membaca manuskripnya dan kebanyakan dilarang meninggalkan tempat persembunyian bawah tanah di dasar gedung delapan lantai mereka. Jaksa membuka penyelidikan kasus kriminal pada kelompok itu dan menyatakan akan membubarkan kelompok kalau tetap melakukan kegiatan ilegal seperti mencegah anggotanya mencari bantuan medis atau pendidikan. Sampai sekarang pihak berwajib belum melakukan penangkapan meskipun polisi mencurigai adanya tindak kekerasan pada anak. Pengadilan selanjutnya akan memutuskan apakah anak-anak diizinkan tetap tinggal dengan orang tua mereka. Kazan yang berada sekitar 800 kilometer di timur Moskow merupakan wilayah Tatarstan yang", "id"},
                {"INDONESIAN", "sukiyaki wikipedia indonesia ensiklopedia bebas berbahasa bebas berbahasa indonesia langsung ke navigasi cari untuk pengertian lain dari sukiyaki lihat sukiyaki irisan tipis daging sapi sayur sayuran dan tahu di dalam panci besi yang dimasak di atas meja makan dengan cara direbus sukiyaki dimakan dengan mence", "id"},
                {"ITALIAN", " a causa di un intervento di manutenzione del sistema fino alle ore circa ora legale costa del pacifico del novembre le campagne esistenti continueranno a essere pubblicate come di consueto anche durante questo breve periodo di inattività ci scusiamo per", "it"},
                {"JAPANESE", " \u3053\u306E\u30DA \u30B8\u3067\u306F \u30A2\u30AB\u30A6\u30F3\u30C8\u306B\u6307\u5B9A\u3055\u308C\u305F\u4E88\u7B97\u306E\u5C65\u6B74\u3092\u4E00\u89A7\u306B\u3057\u3066\u3044\u307E\u3059 \u305D\u308C\u305E\u308C\u306E\u9805\u76EE\u306B\u306F \u4E88\u7B97\u984D\u3068\u7279\u5B9A\u671F\u9593\u306E\u30B9\u30C6 \u30BF\u30B9\u304C\u8868\u793A\u3055\u308C\u307E\u3059 \u73FE\u5728\u307E\u305F\u306F\u4ECA\u5F8C\u306E\u4E88\u7B97\u3092\u8A2D\u5B9A\u3059\u308B\u306B\u306F", "ja"},
                {"KANNADA", " \u0C82\u0CA0\u0CAF\u0CCD\u0CAF\u0CA8\u0CB5\u0CB0\u0CC1 \u0CA4\u0CC1\u0CAE\u0C95\u0CC2\u0CB0\u0CC1 \u0C9C\u0CBF\u0CB2\u0CCD\u0CB2\u0CC6\u0CAF \u0C9A\u0CBF\u0C95\u0CCD\u0C95\u0CA8\u0CBE\u0CAF\u0C95\u0CA8\u0CB9\u0CB3\u0CCD\u0CB3\u0CBF \u0CA4\u0CBE\u0CB2\u0CCD\u0CB2\u0CC2\u0C95\u0CBF\u0CA8 \u0CA4\u0CC0\u0CB0\u0CCD\u0CA5\u0CAA\u0CC1\u0CB0 \u0CB5\u0CC6\u0C82\u0CAC \u0CB8\u0CBE\u0CA7\u0CBE\u0CB0\u0CA3 \u0CB9\u0CB3\u0CCD\u0CB3\u0CBF\u0CAF \u0CB6\u0CCD\u0CAF\u0CBE\u0CA8\u0CC1\u0CAD\u0CCB\u0C97\u0CB0", "kn"},
                {"KOREAN", " \uAC1C\uBCC4\uC801\uC73C\uB85C \uB9AC\uD3EC\uD2B8 \uC561\uC138\uC2A4 \uAD8C\uD55C\uC744 \uBD80\uC5EC\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4 \uC561\uC138\uC2A4 \uAD8C\uD55C \uBD80\uC5EC\uC0AC\uC6A9\uC790\uC5D0\uAC8C \uD504\uB85C\uD544 \uB9AC\uD3EC\uD2B8\uC5D0 \uC561\uC138\uC2A4\uD560 \uC218 \uC788\uB294 \uAD8C\uD55C\uC744 \uBD80\uC5EC\uD558\uC2DC\uB824\uBA74 \uAC00\uC6A9 \uD504\uB85C\uD544 \uC0C1\uC790\uC5D0\uC11C \uD504\uB85C\uD544 \uC774\uB984\uC744 \uC120\uD0DD\uD55C \uB2E4\uC74C", "ko"},
                {"LITHUANINAN", " a išsijungia mano idėja dėl geriausio laiko po pastarųjų savo santykių pasimokiau penki dalykai be kurių negaliu gyventi mano miegamajame tu surasi ideali pora išsilavinimas aukštoji mokykla koledžas universitetas pagrindinis laipsnis metai", "lt"},
                {"LATVIAN", " a gadskārtējā izpārdošana slēpošana jāņi atlaide izmaiņas trafikā kas saistītas ar sezonas izpārdošanu speciālajām atlaidēm u c ir parastas un atslēgvārdi kas ir populāri noteiktos laika posmos šajā laikā saņems lielāku klikšķu", "lv"},
                {"MACEDONIAN", " гласовите коалицијата на вмро дпмне како партија со најмногу освоени гласови ќе добие евра а на сметката на коализијата за македонија", "mk"},
                {"MALAYALAM", " \u0D02 \u0D05\u0D19\u0D4D\u0D19\u0D28\u0D46 \u0D1E\u0D19\u0D4D\u0D19\u0D33\u0D4D \u0D05\u0D35\u0D30\u0D41\u0D1F\u0D46 \u0D2E\u0D41\u0D2E\u0D4D\u0D2A\u0D3F\u0D32\u0D4D \u0D28\u0D3F\u0D28\u0D4D\u0D28\u0D41 \u0D14\u0D1F\u0D41\u0D02 \u0D09\u0D1F\u0D28\u0D46 \u0D28\u0D3F\u0D19\u0D4D\u0D19\u0D33\u0D4D \u0D2A\u0D24\u0D3F\u0D2F\u0D3F\u0D30\u0D3F\u0D2A\u0D4D\u0D2A\u0D3F\u0D32\u0D4D \u0D28\u0D3F\u0D28\u0D4D\u0D28\u0D41 \u0D0E\u0D34\u0D41\u0D28\u0D4D\u0D28\u0D47\u0D31\u0D4D\u0D31\u0D41", "ml"},
                {"MARATHI", "\u0939\u0948\u0926\u0930\u093E\u092C\u093E\u0926  \u0909\u091A\u094D\u091A\u093E\u0930 \u0910\u0915\u093E (\u0938\u0939\u093E\u092F\u094D\u092F\u00B7\u092E\u093E\u0939\u093F\u0924\u0940)\u0924\u0947\u0932\u0941\u0917\u0942: \u0C39\u0C48\u0C26\u0C30\u0C3E\u0C2C\u0C3E\u0C26\u0C41 , \u0909\u0930\u094D\u0926\u0942: \u062D\u06CC\u062F\u0631 \u0622\u0628\u0627\u062F \u0939\u0947 \u092D\u093E\u0930\u0924\u093E\u0924\u0940\u0932 \u0906\u0902\u0927\u094D\u0930 \u092A\u094D\u0930\u0926\u0947\u0936 \u0930\u093E\u091C\u094D\u092F\u093E\u091A\u094D\u092F\u093E \u0930\u093E\u091C\u0927\u093E\u0928\u0940\u091A\u0947 \u0936\u0939\u0930 \u0906\u0939\u0947. \u0939\u0948\u0926\u0930\u093E\u092C\u093E\u0926\u091A\u0940 \u0932\u094B\u0915\u0938\u0902\u0916\u094D\u092F\u093E \u096D\u096D \u0932\u093E\u0916 \u096A\u0966 \u0939\u091C\u093E\u0930 \u0969\u0969\u096A \u0906\u0939\u0947. \u092E\u094B\u0924\u094D\u092F\u093E\u0902\u091A\u0947 \u0936\u0939\u0930 \u0905\u0936\u0940 \u090F\u0915\u0947\u0915\u093E\u0933\u0940 \u0913\u0933\u0916 \u0905\u0938\u0932\u0947\u0932\u094D\u092F\u093E \u092F\u093E \u0936\u0939\u0930\u093E\u0932\u093E \u0910\u0924\u093F\u0939\u093E\u0938\u093F\u0915, \u0938\u093E\u0902\u0938\u094D\u0915\u0943\u0924\u093F\u0915 \u0906\u0923\u093F \u0938\u094D\u0925\u093E\u092A\u0924\u094D\u092F\u0936\u093E\u0938\u094D\u0924\u094D\u0930\u0940\u092F \u0935\u093E\u0930\u0938\u093E \u0932\u093E\u092D\u0932\u093E \u0906\u0939\u0947. \u0967\u096F\u096F\u0966 \u0928\u0902\u0924\u0930 \u0936\u093F\u0915\u094D\u0937\u0923 \u0906\u0923\u093F \u092E\u093E\u0939\u093F\u0924\u0940 \u0924\u0902\u0924\u094D\u0930\u091C\u094D\u091E\u093E\u0928 \u0924\u094D\u092F\u093E\u091A\u092A\u094D\u0930\u092E\u093E\u0923\u0947 \u0914\u0937\u0927\u0928\u093F\u0930\u094D\u092E\u093F\u0924\u0940 \u0906\u0923\u093F \u091C\u0948\u0935\u0924\u0902\u0924\u094D\u0930\u091C\u094D\u091E\u093E\u0928 \u0915\u094D\u0937\u0947\u0924\u094D\u0930\u093E\u0924\u0940\u0932 \u0909\u0926\u094D\u092F\u094B\u0917\u0927\u0902\u0926\u094D\u092F\u093E\u0902\u091A\u0940 \u0935\u093E\u0922 \u0936\u0939\u0930\u093E\u0924 \u091D\u093E\u0932\u0940. \u0926\u0915\u094D\u0937\u093F\u0923 \u092E\u0927\u094D\u092F \u092D\u093E\u0930\u0924\u093E\u0924\u0940\u0932 \u092A\u0930\u094D\u092F\u091F\u0928 \u0906\u0923\u093F \u0924\u0947\u0932\u0941\u0917\u0942 \u091A\u093F\u0924\u094D\u0930\u092A\u091F\u0928\u093F\u0930\u094D\u092E\u093F\u0924\u0940\u091A\u0947 \u0939\u0948\u0926\u0930\u093E\u092C\u093E\u0926 \u0939\u0947 \u0915\u0947\u0902\u0926\u094D\u0930 \u0906\u0939\u0947", "mr"},
                {"NEPALI", "\u0905\u0930\u0942 \u0920\u093E\u090A\u0901\u092C\u093E\u091F\u092A\u0928\u093F \u0916\u0941\u0932\u0947\u0915\u094B \u091B \u092F\u094B \u0916\u093E\u0924\u093E \u0905\u0930 \u0905\u0930\u0942 \u0920\u093E\u090A\u0901\u092C\u093E\u091F\u092A\u0928\u093F \u0916\u0941\u0932\u0947\u0915\u094B \u091B \u092F\u094B \u0916\u093E\u0924\u093E \u0905\u0930 \u0942", "ne"},
                {"DUTCH", " a als volgt te werk om een configuratiebestand te maken sitemap gen py ebruik filters om de s op te geven die moeten worden toegevoegd of uitgesloten op basis van de opmaaktaal elke sitemap mag alleen de s bevatten voor een bepaalde opmaaktaal dit", "nl"},
                {"NORWEGIAN", " a er obligatorisk tidsforskyvning plassering av katalogsøk planinformasjon loggfilbane gruppenavn kontoinformasjon passord domene gruppeinformasjon alle kampanjesporing alternativ bruker grupper oppgaveplanlegger oppgavehistorikk kontosammendrag antall", "no"},
                {"NORWEGIAN", " a for verktylina til å hjelpa deg å nå oss merk at pagerank syninga ikkje automatisk kjem til å henta inn informasjon frå sider med argument dvs frå sider med eit i en dersom datamaskina di er plassert bak ein mellomtenar for vevsider kan det verka", "no"},
                {"PUNJABI", " \u0A02 \u0A26\u0A3F\u0A28\u0A3E\u0A02 \u0A35\u0A3F\u0A1A \u0A2D\u0A3E\u0A08 \u0A38\u0A3E\u0A39\u0A3F\u0A2C \u0A26\u0A40 \u0A2C\u0A41\u0A71\u0A1A\u0A5C \u0A17\u0A4B\u0A2C\u0A3F\u0A70\u0A26 \u0A30\u0A3E\u0A2E \u0A28\u0A3E\u0A32 \u0A05\u0A5C\u0A2B\u0A38 \u0A1A\u0A71\u0A32 \u0A30\u0A39\u0A40 \u0A38\u0A40 \u0A17\u0A4B\u0A2C\u0A3F\u0A70\u0A26 \u0A30\u0A3E\u0A2E \u0A28\u0A47 \u0A2D\u0A3E\u0A08 \u0A38\u0A3E\u0A39\u0A3F\u0A2C \u0A26\u0A40\u0A06\u0A02 \u0A2D\u0A48\u0A23\u0A3E", "pa"},
                {"POLISH", " a australii będzie widział inne reklamy niż użytkownik z kanady kierowanie geograficzne sprawia że reklamy są lepiej dopasowane do użytkownika twojej strony oznacza to także że możesz nie zobaczyć wszystkich reklam które są wyświetlane na", "pl"},
                {"PORTUGUESE", " a abit prevê que a entrada desses produtos estrangeiros no mercado têxtil e vestuário do brasil possa reduzir os preços em cerca de a partir de má notícia para os empresários que terão que lutar para garantir suas margens de lucro mas boa notícia", "pt"},
                {"ROMANIAN", " a anunţurilor reţineţi nu plătiţi pentru clicuri sau impresii ci numai atunci când pe site ul dvs survine o acţiune dorită site urile negative nu pot avea uri de destinaţie daţi instrucţiuni societăţii dvs bancare sau constructoare să", "ro"},
                {"RUSSIAN", " а неправильный формат идентификатора дн назад", "ru"},
                {"SLOVAK", " a aktivovať reklamnú kampaň ak chcete kampaň pred spustením ešte prispôsobiť uložte ju ako šablónu a pokračujte v úprave vyberte si jednu z možností nižšie a kliknite na tlačidlo uložiť kampaň nastavenia kampane môžete ľubovoľne", "sk"},
                {"SLOVENIAN", " adsense stanje prijave za google adsense google adsense račun je bil začasno zamrznjen pozdravljeni hvala za vaše zanimanje v google adsense po pregledu vaše prijavnice so naši strokovnjaki ugotovili da spletna stran ki je trenutno povezana z vašim", "sl"},
                {"SOMALI", " a oo maanta bogga koobaad ugu qoran yahey beesha caalamka laakiin si kata oo beesha caalamku ula guntato soomaaliya waxa aan shaki ku jirin in aakhirataanka dadka soomaalida oo kaliya ay yihiin ku soomaaliya ka saari kara dhibka ay ku jirto", "so"},
                {"ALBANIAN", " a do të kërkoni nga beogradi që të njohë pavarësinë e kosovës zoti thaçi prishtina është gati ta njoh pavarësinë e serbisë ndërsa natyrisht se do të kërkohet një gjë e tillë që edhe beogradi ta njoh shtetin e pavarur dhe sovran të", "sq"},
                {"SWEDISH", " a bort objekt från google desktop post äldst meny öretag dress etaljer alternativ för vad är inne yaste google skrivbord plugin program för nyheter google visa nyheter som är anpassade efter de artiklar som du läser om du till exempel läser", "sv"},
                {"SWAHILI", " a ujumbe mpya jumla unda tafuta na angalia vikundi vya kujadiliana na kushiriki mawazo iliyopangwa kwa tarehe watumiaji wapya futa orodha hizi lugha hoja vishikanisho vilivyo dhaminiwa ujumbe sanaa na tamasha toka udhibitisho wa neno kwa haraka fikia", "sw"},
                {"TAMIL", " \u0B85\u0B99\u0BCD\u0B95\u0BC1 \u0BB0\u0BBE\u0B9C\u0BC7\u0BA8\u0BCD\u0BA4\u0BBF\u0BB0 \u0B9A\u0BCB\u0BB4\u0BA9\u0BBE\u0BB2\u0BCD \u0B95\u0B9F\u0BCD\u0B9F\u0BAA\u0BCD\u0BAA\u0B9F\u0BCD\u0B9F \u0BAA\u0BBF\u0BB0\u0BAE\u0BCD\u0BAE\u0BBE\u0BA3\u0BCD\u0B9F\u0BAE\u0BBE\u0BA9 \u0B9A\u0BBF\u0BB5\u0BA9\u0BCD \u0B95\u0BCB\u0BB5\u0BBF\u0BB2\u0BCD \u0B92\u0BA9\u0BCD\u0BB1\u0BC1\u0BAE\u0BCD \u0B89\u0BB3\u0BCD\u0BB3\u0BA4\u0BC1 \u0BA4\u0BCA\u0B95\u0BC1", "ta"},
                {"TELUGU", " \u0C01 \u0C26\u0C28\u0C30 \u0C1C\u0C2F\u0C3F\u0C02\u0C1A\u0C3F\u0C28 \u0C24\u0C24\u0C4D\u0C35 \u0C2E\u0C30\u0C38\u0C3F \u0C1A\u0C42\u0C21\u0C01 \u0C26\u0C3E\u0C28 \u0C2F\u0C17\u0C41\u0C28\u0C41 \u0C30\u0C3E\u0C1C\u0C2F\u0C4B\u0C17\u0C3F \u0C2F\u0C3F\u0C1F\u0C4D\u0C32\u0C41 \u0C24\u0C47\u0C1C\u0C30\u0C3F\u0C32\u0C4D\u0C32\u0C41\u0C1A\u0C41 \u0C28\u0C41\u0C02\u0C21\u0C41 \u0C35\u0C3F\u0C36\u0C4D\u0C35\u0C26\u0C3E\u0C2D\u0C3F\u0C30\u0C3E\u0C2E \u0C35\u0C3F\u0C28\u0C30 \u0C35\u0C47\u0C2E", "te"},
                {"THAI", " \u0E01\u0E0F\u0E43\u0E19\u0E01\u0E32\u0E23\u0E04\u0E49\u0E19\u0E2B\u0E32 \u0E2B\u0E23\u0E37\u0E2D\u0E2B\u0E19\u0E49\u0E32\u0E40\u0E19\u0E37\u0E49\u0E2D\u0E2B\u0E32 \u0E2B\u0E32\u0E01\u0E17\u0E48\u0E32\u0E19\u0E40\u0E25\u0E37\u0E2D\u0E01\u0E25\u0E07\u0E42\u0E06\u0E29\u0E13\u0E32 \u0E17\u0E48\u0E32\u0E19\u0E2D\u0E32\u0E08\u0E08\u0E30\u0E1B\u0E23\u0E31\u0E1A\u0E15\u0E49\u0E2D\u0E07\u0E40\u0E1E\u0E34\u0E48\u0E21\u0E07\u0E1A\u0E1B\u0E23\u0E30\u0E21\u0E32\u0E13\u0E23\u0E32\u0E22\u0E27\u0E31\u0E19\u0E15\u0E32", "th"},
                {"TAGALOG", " a na ugma sa google ay nakaka bantog sa gitna nang kliks na nangyayari sa pamamagitan nang ordinaryong paggagamit at sa kliks na likha nang pandaraya o hindi tunay na paggamit bunga nito nasasala namin ang mga kliks na hindi kailangan o hindi gusto nang", "tl"},
                {"TURKISH", " a ayarlarınızı görmeniz ve yönetmeniz içindir eğer kampanyanız için günlük bütçenizi gözden geçirebileceğiniz yeri arıyorsanız kampanya yönetimi ne gidin kampanyanızı seçin ve kampanya ayarlarını düzenle yi tıklayın sunumu", "tr"},
                {"UKRAINIAN", " а більший бюджет щоб забезпечити собі максимум прибутків від переходів відстежуйте свої об яви за датою географічним розташуванням", "uk"},
                {"URDU", " \u0622\u067E \u06A9\u0648 \u06A9\u0645 \u0633\u06D2 \u06A9\u0645 \u0645\u0645\u06A9\u0646\u06C1 \u0631\u0642\u0645 \u0686\u0627\u0631\u062C \u06A9\u0631\u062A\u0627 \u06C1\u06D2 \u0627\u0633 \u06A9\u06CC \u0645\u062B\u0627\u0644 \u06A9\u06D2 \u0637\u0648\u0631 \u067E\u0631 \u0641\u0631\u0636 \u06A9\u0631\u06CC\u06BA \u0627\u06AF\u0631 \u0622\u067E \u06A9\u06CC \u0632\u06CC\u0627\u062F\u06C1 \u0633\u06D2 \u0632\u06CC\u0627\u062F\u06C1 \u0642\u06CC\u0645\u062A \u0641\u06CC \u06A9\u0644\u0650\u06A9 \u0627\u0645\u0631\u06CC\u06A9\u06CC \u0688\u0627\u0644\u0631 \u0627\u0648\u0631 \u06A9\u0644\u0650\u06A9 \u06A9\u0631\u0646\u06D2 \u06A9\u06CC \u0634\u0631\u062D \u06C1\u0648 \u062A\u0648", "ur"},
                {"VIETNAMESE", " adsense cho n\u00F4\u0323i dung nha\u0300 cung c\u00E2\u0301p di\u0323ch vu\u0323 di \u0111\u00F4\u0323ng xa\u0301c minh ti\u0301n du\u0323ng thay \u0111\u00F4\u0309i nha\u0303n kg ca\u0301c \u00F4 xem chi phi\u0301 cho t\u01B0\u0300 ch\u00F4\u0301i ca\u0301c \u0111\u01A1n \u0111\u0103\u0323t ha\u0300ng da\u0323ng c\u00E2\u0301p d\u01B0\u0303 li\u00EA\u0323u a\u0301c minh trang web cu\u0309a ba\u0323n \u0111\u00EA\u0309 xem", "vi"},
                {"CHINESE", "\u4EA7\u54C1\u7684\u7B80\u62A5\u548C\u516C\u544A \u63D0\u4EA4\u8BE5\u7533\u8BF7\u540E\u65E0\u6CD5\u8FDB\u884C\u66F4\u6539 \u8BF7\u786E\u8BA4\u60A8\u7684\u9009\u62E9\u662F\u6B63\u786E\u7684 \u5BF9\u4E8E\u8981\u63D0\u4EA4\u7684\u56FE\u4E66 \u6211\u786E\u8BA4 \u6211\u662F\u7248\u6743\u6240\u6709\u8005\u6216\u5DF2\u5F97\u5230\u7248\u6743\u6240\u6709\u8005\u7684\u6388\u6743 \u8981\u66F4\u6539\u60A8\u7684\u56FD\u5BB6 \u5730\u533A \u8BF7\u5728\u6B64\u8868\u7684\u6700\u4E0A\u7AEF\u66F4\u6539\u60A8\u7684", "zh-cn"},
                {"CHINESE-TW", " \u628A\u6587\u7AE0\u6574\u7406\u6B78\u6A94\u662F\u76F8\u7576\u91CD\u8981\u7684\u3002\u5927\u90E8\u5206\u7684\u7DB2\u8A8C\u6703\u4EE5\u65E5\u671F\uFF0C\u4F8B\u5982\u5E74\u3001\u6708\u3001\u65E5\u7B49\u65B9\u5F0F\u4F86\u5F59\u6574\u6587\u7AE0\uFF0C\u6216\u662F\u4EE5\u5206\u985E\u65B9\u5F0F\u4F86\u6B78\u7D0D\u67D0\u4E9B\u5167\u5BB9\uFF0C\u9054\u5230\u4FBF\u65BC\u627E\u5C0B\u53CA\u95B1\u8B80\u7684\u6548\u679C", "zh-tw"},
        });
    }

    private final String languageName;
    private final String s;
    private final String expectedLang;
    private final Detector detector;

    public NormalMessageDetectorTest(final String languageName, final String s, final String expectedLang) {
        this.languageName = languageName;
        this.s = s;
        this.expectedLang = expectedLang;

        final DetectorFactory detectorFactory = new DetectorFactory(false);
        detector = detectorFactory.create();
    }

    @Test
    public void testLanguageDetection() throws Exception {
        detector.append(s);
        final String detectedLang = detector.detect();

        assertEquals("Language should equal to " + languageName, expectedLang, detectedLang);
    }
}
