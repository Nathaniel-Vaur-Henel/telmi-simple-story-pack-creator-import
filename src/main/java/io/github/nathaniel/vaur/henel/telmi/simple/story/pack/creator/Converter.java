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

package io.github.nathaniel.vaur.henel.telmi.simple.story.pack.creator;

import io.github.nathaniel.vaur.henel.telmi.simple.story.pack.creator.input.Description;
import io.github.nathaniel.vaur.henel.telmi.simple.story.pack.creator.output.TelmiPack;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Convertit les descriptions d'histoires en packs d'histoires compatibles Telmi
 */
public class Converter {

    public static final String AGE_TITLE_SEPARATOR = "+] ";
    public static final String COMMENT_PREFIX = "#";

    public void importAll(Path importPath) throws IOException {
        Files.readAllLines(importPath).stream()
            .filter(this::isValid)
            .map(Description::of)
            .map(TelmiPack::of)
            .map(this::write)
            .forEach(path -> System.out.println("Importing tale: " + path.getFileName()));
    }

    private boolean isValid(String line) {
        return !line.isBlank() && !line.startsWith(COMMENT_PREFIX);
    }

    private Path write(TelmiPack telmiPack) {
        try {
            System.out.println("Writing pack: " + telmiPack.mainTitleTxt());
            Path root = Paths.get("out", telmiPack.age() + AGE_TITLE_SEPARATOR + telmiPack.mainTitleTxt());
            Files.createDirectories(root);
            Files.writeString(root.resolve("category.txt"), telmiPack.categoryTxt());
            Files.writeString(root.resolve("main-title.txt"), telmiPack.mainTitleTxt());
            copy(root, telmiPack.uniqueImage(), "main-title");
            copy(root, telmiPack.uniqueImage(), "cover");

            Path titleRoot = root.resolve("0");
            Files.createDirectories(titleRoot);
            copy(titleRoot, telmiPack.uniqueImage(), "title");
            copy(titleRoot, telmiPack._0Path(), "title");
            return root;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void copy(Path root, String initialFile, String targetName) throws IOException {
        Path source = Paths.get(initialFile);
        Path target = root.resolve(targetName + getExtension(initialFile));
        Files.copy(source, target, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
    }

    private String getExtension(String mainTitleImage) {
        return mainTitleImage.substring(mainTitleImage.lastIndexOf('.'));
    }
}
