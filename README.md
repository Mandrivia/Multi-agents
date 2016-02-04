# Multi-agents
TPs Systèmes Multi-agents (Particles, Wator, Hunter)

## Architecture Globale

## Particles

La chambre à particules est un environnement dans lequels des billes (les agents) se déplacent en se heurtant les unes aux autres, ou aux murs (dans le cas ou le monde n'est pas torique).
L'architecture globale est étendue avec un agent Particle, doté d'une intelligence basique. 
Chaque agent est crée avec une direction (en X et Y) aléatoire (possiblement nulle) qui indique dans quelle direction il se déplacera à chaque tour.
Cette direction est fixe, mais sera modifié à chaque collision avec une bille la direction étant inversée, en X et Y (x-1). En cas de collision avec un mur, pour simuler un angle de redirection, seule une des directions est changée (Y quand la collision a lieu en X et inversement).

## Wator

Wator est une simulation d'environnement confiné (optionnellmement torique) dans lequel évoluent des thons et des requins qui peuvent se reproduire. Ces derniers ont en plus besoin de se nourrir sous peine de mourir.
Le but de cette simulation est donc d'obtenir un écosystème équilibré dans lequel les deux espèces peuvent survivre indéfiniment, malgré des phases de domination ou de quasi-extinction.

L'architecture globale est étendue avec un agent Fish qui gère les notions de reproduction, de mort, de déplacement et de voisinage (de Moore).
Un agent Tuna s'occupe de spécifier les caractèristiques propres au thon comme sa couleur (pour la vue).
Enfin, l'agent Shark, représente un requin, et son comportement propre. Ce dernier a comme objectif principal de se reproduire.
Ainsi, un requin cherchera en priorité à se reproduire, puis à se nourrir et enfin à se déplacer. A noter qu'il se déplacera systématiquement si possible, même après reproduction et/ou s'être nourrit.

## Hunter

Le hunter est une simulation dans un environnement clos, dans lequel un ou plusieurs chasseurs ont pour but d'attraper une cible.
L'architecture globale est étendue avec un agent Target, qui se déplace soit de façon autonome et aléatoire, soit contrôlée par un joueur via le clavier.
Cet agent calcule à chacun de ses déplacements une carte des distances à l'aide de l'algortihme de Dijkstra. 
Cette dernière est utilisée par les agent Hunter pour trouver le plus court chemin jusqu'à la cible et l'intercepter.
Pour cela, le chasseur étudie son voisinnage (de Moore) pour trouver le meilleur choix, c'est à dire la valeur la plus faible dans son voisinage immédiat pour le rapproche le plus de sa cible.
Un dernier agent est ajouté, l'agent Wall. Comme son nom l'indique c'est un agent qui ne fait rien, si ce n'est bloquer la place pour donner un relief à l'environnement.
