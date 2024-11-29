/*
 * MIT License
 *
 * Copyright (c) 2024 Nathaniel Vaur Henel
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package io.github.nathaniel.vaur.henel.telmi.simple.story.pack.creator.output;

import io.github.nathaniel.vaur.henel.telmi.simple.story.pack.creator.input.Description;

/**
 * Données à exporter pour créer le pack d'histoire
 */
public class TelmiPack {
    private int age;
    /**
     * Contenu du fichier category.txt
     */
    private String categoryTxt;
    /**
     * Contenu du fichier main-title.txt
     */
    private String mainTitleTxt;
    /**
     * Chemin de des images main-title.{imageExtension}, cover.{imageExtension} et /0/title.{imageExtension}
     */
    private String uniqueImage;
    /**
     * Chemin du fichier 0/title.{audioExtension/txt}
     */
    private String _0Path;
    /**
     * Indique si le conte est un fichier texte
     */
    private boolean taleIsTxt;

    public static TelmiPack of(Description description) {
        TelmiPack telmiPack = new TelmiPack();
        telmiPack.age = description.age();
        telmiPack.categoryTxt = description.category();
        telmiPack.mainTitleTxt = description.title();
        telmiPack.uniqueImage = description.imagePath();
        telmiPack._0Path = description.talePath();
        telmiPack.taleIsTxt = description.talePath().toLowerCase().endsWith(".txt");
        return telmiPack;
    }

    public int age() {
        return age;
    }

    public String categoryTxt() {
        return categoryTxt;
    }

    public String mainTitleTxt() {
        return mainTitleTxt;
    }

    public String uniqueImage() {
        return uniqueImage;
    }

    public String _0Path() {
        return _0Path;
    }
}
