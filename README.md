# Telmi Simple Story Pack Creator

> **Note :** Ce projet est un outil personnel et n'est pas affilié à [Telmi](https://telmi.fr/). Il est possible que l'outil ne fonctionne pas correctement ou que les fichiers générés ne soient pas corrects. Utilisez-le à vos risques et périls.

Voici un outil tout simple pour créer des packs d'histoires [Telmi](https://telmi.fr/) à partir d'une image et d'un fichier audio.

En effet, je trouvais fastidieux de créer à la main un pack d'histoire [Telmi](https://telmi.fr/) pour **une** histoire, alors j'ai créé cet outil pour automatiser le processus.

> Attention : 
> - Cet outil est très simple et ne gère pas les erreurs. Il est donc possible qu'il ne fonctionne pas correctement si les fichiers d'entrée ne sont pas corrects.
> - Cet outil n'est actuellement pas release-ready. Il est donc possible qu'il ne fonctionne pas correctement.
> - Cet outil nécessite actuellement une installation de Java et d'un IDE pour être utilisé.
> - Si vous modifiez les fichiers d'un pack, en particulier l'extension, assurez-vous de supprimer les doublons. Exemple : Je ne sais pas comment réagit la [Telmi](https://telmi.fr/) s'il y a 2 fichiers `main-title` l'un en `.jpg` et l'autre en `.webp`.
> - Cet outil n'a pas pour but de remplacer le studio de création de [Telmi](https://telmi.fr/). Il est juste là pour automatiser la création de packs contenant une histoire.

Cet outil :
- crée l'arborescence du pack
- utilise 3 fois la même image pour créer les 3 images nécessaires à un pack d'histoire [Telmi](https://telmi.fr/)..
- crée un fichier `main-title.txt` pour lire le titre de l'histoire.
- crée un fichier `category.txt` pour relier des histoires entre elles.
- copie le fichier audio dans le pack.


## Utilisation

1. Téléchargez les sources.
2. Ouvrez le projet dans votre IDE.
3. Lancez l'app en exécutant la classe `Main`. 
   - Si vous voulez, vous pouvez spécifier un chemin vers un fichier `.csv` contenant les chemins des fichiers audio et image à utiliser. Sinon, l'app utilise le fichier `import.csv` à la racine du projet.
4. Les fichiers sont **copiés** dans le dossier `output` du lancement de l'app.
5. _Aucun fichier n'est supprimé._
6. _Aucune vérification de la validité du pack n'est effectuée._


## Format du fichier `.csv`

Le fichier `import.csv` du projet explique ce que doit contenir le fichier `.csv` pour que l'app fonctionne correctement.

