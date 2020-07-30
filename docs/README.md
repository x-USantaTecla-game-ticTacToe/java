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
<h1>TicTacToe. Solución 5.2. <strong>modelViewPresenter.presentationModel</strong></h1>
<div class="details">
<span id="author" class="author">Santa Tecla</span><br>
<span id="email" class="email"><a href="mailto:parqueNaturalSantaTecla@gmail.com">parqueNaturalSantaTecla@gmail.com</a></span><br>
<span id="revnumber">version 0.4.0</span>
</div>
<div id="toc" class="toc">
<div id="toctitle">Índice</div>
<ul class="sectlevel1">
<li><a href="#requisitos-1-básica">Requisitos 2. <strong>Gráficos</strong></a></li>
<li><a href="#vista-de-lógicadiseño">Vista de Lógica/Diseño</a>
<ul class="sectlevel2">
<li><a href="#arquitectura">Arquitectura</a></li>
<li><a href="#paquete-tictactoe">Paquete <em>tictactoe</em></a></li>
<li><a href="#paquete-tictactoe-views">Paquete <em>tictactoe.views</em></a></li>
<li><a href="#paquete-tictactoe-views-console">Paquete <em>tictactoe.views.console</em></a></li>
<li><a href="#paquete-tictactoe-views-graphics">Paquete <em>tictactoe.views.graphics</em></a></li>
<li><a href="#paquete-tictactoe-models">Paquete <em>tictactoe.models</em></a></li>
<li><a href="#paquete-tictactoe-controllers">Paquete <em>tictactoe.controllers</em></a></li>
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
<h2 id="requisitos-1-básica">Requisitos 2. <strong>Gráficos</strong></h2>
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
<p><em>Interfaz: <strong class="lime-background">Gráfica</strong> y <strong>Texto</strong></em></p>
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
<div class="ulist">
<ul>
<li>
<p><strong class="lime-background">Patrón Template Method (Factory Method)</strong>, <em>para clases principales</em></p>
</li>
<li>
<p><strong class="lime-background">Patrón Model View Presenter</strong>, <em>para incluir controllers</em></p>
</li>
</ul>
</div>
</li>
</ul>
</div>
<div class="sect2">
<h3 id="arquitectura">Arquitectura</h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/arquitecturaVersion5.svg" alt="arquitecturaVersion5" width="500" height="700">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe">Paquete <em>tictactoe</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeVersion5.svg" alt="tictactoeVersion5" width="1000" height="400">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-views">Paquete <em>tictactoe.views</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeViewsVersion5.svg" alt="tictactoeViewsVersion5" width="800" height="548">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-views-console">Paquete <em>tictactoe.views.console</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeViewsConsoleVersion5.svg" alt="tictactoeViewsConsoleVersion5" width="900" height="800">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-views-graphics">Paquete <em>tictactoe.views.graphics</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeViewsGraphicsVersion5.svg" alt="tictactoeViewsGraphicsVersion5" width="1200" height="1100">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-models">Paquete <em>tictactoe.models</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeModelsVersion5.svg" alt="tictactoeModelsVersion5" width="1000" height="1000">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-controllers">Paquete <em>tictactoe.controllers</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeControllersVersion5.svg" alt="tictactoeControllersVersion5" width="800" height="400">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-utils">Paquete <em>utils</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/utilsVersion5.svg" alt="utilsVersion5" width="456" height="548">
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
<p><strong class="red line-through"><em><span class="red">DRY: clases principales</span></em></strong></p>
</li>
</ul>
</div>
</div>
<div class="sect2">
<h3 id="rediseño">Rediseño</h3>
<div class="ulist">
<ul>
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
<img src="build/docs/asciidoc/images/diagramaImplementacion.svg" alt="diagramaImplementacion" width="1000" height="200">
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
Version 0.4.0<br>
Last updated 2020-07-30 11:00:00 +0200
</div>
</div>
</html>