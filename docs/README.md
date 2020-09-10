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
<h1>TicTacToe. Solución 15.6. <strong>mvp.pm.withPrototype</strong></h1>
<div class="details">
<span id="author" class="author">Santa Tecla</span><br>
<span id="email" class="email"><a href="mailto:parqueNaturalSantaTecla@gmail.com">parqueNaturalSantaTecla@gmail.com</a></span><br>
<span id="revnumber">version 0.14.0</span>
</div>
<div id="toc" class="toc">
<div id="toctitle">Índice</div>
<ul class="sectlevel1">
<li><a href="#requisitos-4-clienteservidor">Requisitos 5. <strong>Ficheros</strong></a></li>
<li><a href="#vista-de-lógicadiseño">Vista de Lógica/Diseño</a>
<ul class="sectlevel2">
<li><a href="#arquitectura">Arquitectura</a></li>
<li><a href="#paquete-tictactoe">Paquete <em>tictactoe</em></a></li>
<li><a href="#paquete-tictactoe-views">Paquete <em>tictactoe.views</em></a></li>
<li><a href="#paquete-tictactoe-views-menus">Paquete <em>tictactoe.views.menus</em></a></li>
<li><a href="#paquete-tictactoe-views-models">Paquete <em>tictactoe.views.models</em></a></li>
<li><a href="#paquete-tictactoe-models">Paquete <em>tictactoe.models</em></a></li>
<li><a href="#paquete-tictactoe-models-dao">Paquete <em>tictactoe.models.DAO</em></a></li>
<li><a href="#paquete-tictactoe-models-database">Paquete <em>tictactoe.models.database</em></a></li>
<li><a href="#paquete-tictactoe-models-files">Paquete <em>tictactoe.models.Files</em></a></li>
<li><a href="#paquete-tictactoe-types">Paquete <em>tictactoe.types</em></a></li>
<li><a href="#paquete-tictactoe-controllers">Paquete <em>tictactoe.controllers</em></a></li>
<li><a href="#paquete-tictactoe-controllers-implementation">Paquete <em>tictactoe.controllers.implementation</em></a></li>
<li><a href="#paquete-tictactoe-distributed">Paquete <em>tictactoe.distributed</em></a></li>
<li><a href="#paquete-tictactoe-distributed-dispatchers">Paquete <em>tictactoe.distributed.dispatchers</em></a></li>
<li><a href="#paquete-tictactoe-distributed-dispatchers-errors">Paquete <em>tictactoe.distributed.dispatchers.errors</em></a></li>
<li><a href="#paquete-tictactoe-distributed-dispatchers-save">Paquete <em>tictactoe.distributed.dispatchers.save</em></a></li>
<li><a href="#paquete-tictactoe-distributed-dispatchers-undoredo">Paquete <em>tictactoe.distributed.dispatchers.undoredo</em></a></li>
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
<h2 id="requisitos-4-clienteservidor">Requisitos 6. <strong>BaseDatos</strong></h2>
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
<p><em>Funcionalidad: <strong>Básica</strong> + <strong>undo/redo</strong></em></p>
</li>
<li>
<p><em>Interfaz: <strong class="line-through">Gráfica</strong> y <strong>Texto</strong></em></p>
</li>
<li>
<p><em>Distribución: <strong>Standalone</strong> + <strong>Client/Server</strong></em></p>
</li>
<li>
<p><em>Persistencia: <span class="lime-background"><strong>Ficheros</strong> + <strong>BaseDatos</strong></span></em></p>
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
<p><strong>Modelo/Vista/Presentador</strong> con <strong>Base de datos</strong></p>
</li>
</ul>
</div>
<div class="sect2">
<h3 id="arquitectura">Arquitectura</h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/arquitecturaVersion14.svg" alt="arquitecturaVersion14" width="1000" height="600">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe">Paquete <em>tictactoe</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeVersion14.svg" alt="tictactoeVersion14" width="500" height="400">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-views">Paquete <em>tictactoe.views</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeViewsVersion14.svg" alt="tictactoeViewsVersion14" width="1200" height="600">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-views-models">Paquete <em>tictactoe.views.models</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeViewsModels.svg" alt="tictactoeViewsModels" width="1200" height="1000">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-views-menus">Paquete <em>tictactoe.views.menus</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeViewsMenus.svg" alt="tictactoeViewsMenus" width="1000" height="700">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-models">Paquete <em>tictactoe.models</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeModelsVersion14.svg" alt="tictactoeModelsVersion14" width="1200" height="1300">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-models-DAO">Paquete <em>tictactoe.models.DAO</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeModelsDAO.svg" alt="tictactoeModelsDAO" width="600" height="600">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-models-database">Paquete <em>tictactoe.models.database</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeModelsDatabase.svg" alt="tictactoeModelsDatabase" width="1200" height="1000">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-models-files">Paquete <em>tictactoe.models.Files</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeModelsFiles.svg" alt="tictactoeModelsFiles" width="1200" height="1000">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-controllers">Paquete <em>tictactoe.controllers</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeControllersVersion14.svg" alt="tictactoeControllersVersion14" width="1000" height="600">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-controllers-implementation">Paquete <em>tictactoe.controllers.implementation</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeControllersImplementation.svg" alt="tictactoeControllersImplementation" width="1848" height="514">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-distributed">Paquete <em>tictactoe.distributed</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeDistributed.svg" alt="tictactoeDistributed" width="1000" height="600">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-distributed-dispatchers">Paquete <em>tictactoe.distributed.dispatchers</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeDistributerDispatchers.svg" alt="tictactoeDistributerDispatchers" width="1000" height="600">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-distributed-dispatchers-undoredo">Paquete <em>tictactoe.distributed.dispatchers.undoredo</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeDistributerDispatchersUndoredo.svg" alt="tictactoeDistributerDispatchersUndoredo" width="600" height="600">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-distributed-dispatchers-save">Paquete <em>tictactoe.distributed.dispatchers.save</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeDistributerDispatchersSave.svg" alt="tictactoeDistributerDispatchersSave" width="800" height="600">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-tictactoe-distributed-dispatchers-errors">Paquete <em>tictactoe.distributed.dispatchers.errors</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/tictactoeDistributerDispatchersErrors.svg" alt="tictactoeDistributerDispatchersErrors" width="600" height="600">
</div>
</div>
</div>
<div class="sect2">
<h3 id="paquete-utils">Paquete <em>utils</em></h3>
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/utilsVersion14.svg" alt="utilsVersion14" width="700" height="548">
</div>
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
<img src="build/docs/asciidoc/images/diagramaImplementacionClient.svg" alt="diagramaImplementacionClient" width="1000" height="207">
<img src="build/docs/asciidoc/images/diagramaImplementacionServer.svg" alt="diagramaImplementacionServer" width="1000" height="207">
</div>
</div>
</div>
</div>
<div class="sect1">
<h2 id="vista-de-desplieguefísica">Vista de Despliegue/Física</h2>
<div class="sectionbody">
<div class="imageblock">
<div class="content">
<img src="build/docs/asciidoc/images/diagramaDespliegue.svg" alt="diagramaDespliegue" width="600" height="207">
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
Version 0.14.0<br>
Last updated 2020-08-30 21:30:00 +0200
</div>
</div>
</html>