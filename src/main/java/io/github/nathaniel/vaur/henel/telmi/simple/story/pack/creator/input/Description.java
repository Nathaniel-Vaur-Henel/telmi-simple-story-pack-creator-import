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

package io.github.nathaniel.vaur.henel.telmi.simple.story.pack.creator.input;

import java.util.Optional;

/**
 * Classe représentant un conte tel que décrit dans le fichier csv d'import
 *
 * @param age       L'âge minimum pour lire le conte
 * @param title     Titre du conte
 * @param talePath  Chemin du fichier audio ou texte du conte
 * @param imagePath Chemin de l'image du conte
 * @param category  Catégorie du conte
 */
public record Description(int age, String title, String talePath, String imagePath, String category) {
    public Description(int age, String title, String talePath, String imagePath, String category) {
        this.title = title;
        this.talePath = talePath;
        this.imagePath = imagePath;
        this.category = category;
        if (age < 0) {
            System.err.println("Âge négatif: " + age + ". Remplacé par 0");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public static Optional<Description> of(String csvLine) {
        String[] split = csvLine.split(";");
        if (split.length < 4 || split.length > 5) {
            System.err.println("Ligne invalide, donc ignorée : " + csvLine);
            return Optional.empty();
        }
        int age = Integer.parseInt(split[0]);
        String title = split[1];
        String talePath = split[2];
        String imagePath = split[3];
        String category;
        if (split.length == 4) {
            category = "";
        } else {
            category = split[4];
        }
        return Optional.of(new Description(age, title, talePath, imagePath, category));
    }
}
