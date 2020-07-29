<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="generator" content="Asciidoctor 2.0.8">
<meta name="author" content="Santa Tecla">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic%7CNoto+Serif:400,400italic,700,700italic%7CDroid+Sans+Mono:400,700">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="book">
<div id="header">
<h1>TicTacToe. Solucion 2.1. <strong>documentView</strong></h1>
<div class="details">
<span id="author" class="author">Santa Tecla</span><br>
<span id="email" class="email"><a href="mailto:parqueNaturalSantaTecla@gmail.com">parqueNaturalSantaTecla@gmail.com</a></span><br>
<span id="revnumber">version 0.1.3</span>
</div>
<div id="toc" class="toc">
<div id="toctitle">Índice</div>
<ul class="sectlevel1">
<li><a href="#requisitos-1-básica">Requisitos 1. <strong>Básica</strong></a></li>
<li><a href="#vista-de-lógicadiseño">Vista de Lógica/Diseño</a>
<ul class="sectlevel2">
<li><a href="#arquitectura">Arquitectura</a></li>
<li><a href="#paquete-tictactoe">Paquete <em>tictactoe</em></a></li>
<li><a href="#paquete-tictactoe-views">Paquete <em>tictactoe.views</em></a></li>
<li><a href="#paquete-tictactoe-models">Paquete <em>tictactoe.models</em></a></li>
<li><a href="#paquete-utils">Paquete <em>utils</em></a></li>
</ul>
</li>
<li><a href="#calidad-del-software">Calidad del Software</a>
<ul class="sectlevel2">
<li><a href="#diseño">Diseño</a></li>
<li><a href="#rediseño">Rediseño</a></li>
</ul>
</li>
<li><a href="#vista-de-desarrolloimplementación">Vista de Desarrollo/Implementación</a></li>
<li><a href="#vista-de-desplieguefísica">Vista de Despliegue/Física</a></li>
<li><a href="#vista-de-procesos">Vista de Procesos</a></li>
</ul>
</div>
</div>
<div id="content">
<div class="sect1">
<h2 id="requisitos-1-básica">Requisitos 1. <strong>Básica</strong></h2>
<div class="sectionbody">
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 50%;">
<col style="width: 50%;">
</colgroup>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="ulist">
<ul>
<li>
<p><a href="https://en.wikipedia.org/wiki/Tic-tac-toe"><strong>Wiki</strong></a></p>
<div class="ulist">
<ul>
<li>
<p><em>Funcionalidad: <strong>Básica</strong></em></p>
</li>
<li>
<p><em>Interfaz: <strong>Texto</strong></em></p>
</li>
<li>
<p><em>Distribución: <strong>Standalone</strong></em></p>
</li>
<li>
<p><em>Persistencia: <strong>No</strong></em></p>
</li>
</ul>
</div>
</li>
</ul>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/Dibujo.jpg" alt="Dibujo" width="300" height="300">
</div>
</div></div></td>
</tr>
</tbody>
</table>
</div>
</div>
<div class="sect1">
<h2 id="vista-de-lógicadiseño">Vista de Lógica/Diseño</h2>
<div class="sectionbody">
<div class="ulist">
<ul>
<li>
<p>Arquitectura Documento/Vista mediante <strong>Patrón de Vista Separada</strong></p>
</li>
</ul>
</div>
<div class="sect2">
<h3 id="arquitectura">Arquitectura</h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/version2Arquitectura.svg" alt="version2Arquitectura" width="400" height="400">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe">Paquete <em>tictactoe</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/version2TicTacToe.svg" alt="version2TicTacToe" width="300" height="300">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-views">Paquete <em>tictactoe.views</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeViews.svg" alt="tictactoeViews" width="800" height="800">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-models">Paquete <em>tictactoe.models</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeModels.svg" alt="tictactoeModels" width="900" height="900">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-utils">Paquete <em>utils</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/utils2.svg" alt="utils2" width="456" height="548">
</div>
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="calidad-del-software">Calidad del Software</h2>
<div class="sectionbody">
<div class="sect2">
<h3 id="diseño">Diseño</h3>
<div class="ulist">
<ul>
<li>
<p><span class="red"><em><strong>Método largo</strong>: Método "play" de TicTacToe,&#8230;&#8203;</em></span></p>
</li>
</ul>
</div>
</div>
<div class="sect2">
<h3 id="rediseño">Rediseño</h3>
<div class="ulist">
<ul>
<li>
<p><em>Nueva interfaz: Gráfica</em></p>
<div class="ulist">
<ul>
<li>
<p><span class="red"><em><strong>Clases Grandes</strong>: los Modelos asumen la responsabilidad y crecen en líneas, métodos, atributos, &#8230;&#8203; con cada nueva tecnología</em></span></p>
</li>
<li>
<p><span class="red"><em><strong>Alto acoplamiento</strong>: los Modelos con cada nueva tecnología de interfaz (consola, gráficos, web, &#8230;&#8203;)</em></span></p>
</li>
<li>
<p><span class="red"><em><strong>Baja cohesión</strong>: cada Modelo está gestionando sus atributos y las tecnologías de interfaz</em></span></p>
</li>
<li>
<p><span class="red"><em><strong>Open/Close</strong>: hay que modificar los modelos que estaban funcionando previamente para escoger una tecnología de vista u otra (if&#8217;s anidados)</em></span></p>
</li>
</ul>
</div>
</li>
<li>
<p><em>Nuevas funcionalidades: undo/redo, demo, estadísiticas,&#8230;&#8203;</em></p>
<div class="ulist">
<ul>
<li>
<p><span class="red"><em><strong>Clases Grandes</strong>: los Modelos asumen la responsabilidad y crecen en líneas, métodos, atributos, &#8230;&#8203; con las nuevas funcionalidades</em></span></p>
</li>
<li>
<p><span class="red"><em><strong>Open/Close</strong>: hay que modificar los modelos que estaban funcionando previamente para incorporar nuevas funcionalidades</em></span></p>
</li>
</ul>
</div>
</li>
</ul>
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="vista-de-desarrolloimplementación">Vista de Desarrollo/Implementación</h2>
<div class="sectionbody">
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/diagramaImplementacion.svg" alt="diagramaImplementacion" width="518" height="158">
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="vista-de-desplieguefísica">Vista de Despliegue/Física</h2>
<div class="sectionbody">
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/diagramaDespliegue.svg" alt="diagramaDespliegue" width="203" height="207">
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="vista-de-procesos">Vista de Procesos</h2>
<div class="sectionbody">
<div class="ulist">
<ul>
<li>
<p>No hay concurrencia</p>
</li>
</ul>
</div>
</div>
</div>
</div>
<div id="footer">
<div id="footer-text">
Version 0.1.3<br>
Last updated 2020-07-28 16:30:00 +0200
</div>
</div>
</html>