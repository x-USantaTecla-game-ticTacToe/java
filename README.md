<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="generator" content="Asciidoctor 2.0.8">
<meta name="author" content="Universo Santa Tecla">
<link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Open+Sans:300,300italic,400,400italic,600,600italic%7CNoto+Serif:400,400italic,700,700italic%7CDroid+Sans+Mono:400,700">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
</head>
<body class="book">
<div id="header">
<h1>TicTacToe</h1>
<div class="details">
<span id="author" class="author">Universo Santa Tecla</span><br>
<span id="email" class="email"><a href="mailto:USantaTecla@gmail.com">USantaTecla@gmail.com</a></span><br>
<span id="revnumber">version 0.0.1</span>
</div>
</div>
<div id="content">
<div id="preamble">
<div class="sectionbody">
<table class="tableblock frame-all grid-all stretch">
<colgroup>
<col style="width: 10%;">
<col style="width: 15%;">
<col style="width: 25%;">
<col style="width: 50%;">
</colgroup>
<thead>
<tr>
<th class="tableblock halign-left valign-top">Tema</th>
<th class="tableblock halign-left valign-top">Requisitos</th>
<th class="tableblock halign-left valign-top">Solución</th>
<th class="tableblock halign-left valign-top">Incremento</th>
</tr>
</thead>
<tbody>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><strong>Diseño</strong></p>
</div></div></td>
<td class="tableblock halign-left valign-top" rowspan="2"><div class="content"><div class="paragraph">
<p><span class="red">TicTacToe. Requisitos. Versión 1. <strong>Básica</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="red">TicTacToe. Solucion. Versión 1.1. <strong>domainModel</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="red">Clases del Modelo del Dominio <strong>pero acopladas a tecnologías de interfaz ahora y todas con la Ley del Cambio Continuo y de granos grueso con el advenimiento de nueva funcionalidad </strong></span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><strong>Diseño Modular</strong></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="red">TicTacToe. Solucion. Versión 2.1. <strong>documentView</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="red">Clases Vistas de Texto separadas de los Modelos del Dominio <strong>pero con Modelos de grano grueso con el advenimiento de nueva funcionalidad</strong></span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top" rowspan="6"><div class="content"><div class="paragraph">
<p><strong>Diseño Orientado a Objetos</strong></p>
</div></div></td>
<td class="tableblock halign-left valign-top" rowspan="6"><div class="content"><div class="paragraph">
<p><span class="blue">TicTacToe. Requisitos. Versión 2. <strong>Gráficos</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">TicTacToe. Solucion. Versión 3.2. <strong>dv. withoutFactoryMethod</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">Clase Vistas de Interfaz Gráfica de Usuario <strong>pero con DRY en Vistas de tecnologías diferentes y con Modelos de grano grueso con el advenimiento de nueva funcionalidad</strong></span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">TicTacToe. Solucion. Versión 4.2. <strong>dv. withFactoryMethod</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">Clase Vista abstracta para Open/Close de sus tecnologías <strong>pero con Modelos de grano grueso con el advenimiento de nueva funcionalidad</strong></span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">TicTacToe. Solucion. Versión 5.2. <strong>modelViewPresenter. presentationModel</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">Clases Controladoras entre Vistas y Modelos por cada Caso de Uso <strong>pero con la clase Principal y las Vistas acopladas a cada controlador actual y futuro</strong></span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">TicTacToe. Solucion. Versión 6.2. <strong>mvp. pm. withFacade</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">Clase Lógica que encapsula Controladores y Modelos <strong>pero con Vistas con DRY en la Lógica de Control</strong></span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">TicTacToe. Solucion. Versión 7.2. <strong>mvp. pm. withoutDoubleDispatching</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">Clase Estado para la Inversión de Control de Vistas a la Lógica <strong>pero violando el Principio de Sustitución de Liskov</strong></span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">TicTacToe. Solucion. Versión 8.2. <strong>mvp. pm. withDoubleDispatching</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="blue">Clase Vistador de Controladores para Técnica de Doble Despacho</span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top" rowspan="7"><div class="content"><div class="paragraph">
<p><strong>Patrones de Diseño</strong></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="green">TicTacToe. Requisitos. Versión 3. <strong>UndoRedo</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="green">TicTacToe. Solucion. Versión 9.3. <strong>mvp. pm. withComposite</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="green">Clase Comando del menú y Controlador Compuesto de ciertos Estados para Open/Close con nuevos Casos de Uso</span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top" rowspan="2"><div class="content"><div class="paragraph">
<p><span class="yellow">TicTacToe. Requisitos. Versión 4. <strong>ClienteServidor</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="yellow">TicTacToe. Solucion. Versión 10.4. <strong>mvp. pm. withoutProxy</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="yellow">Clase TCP/IP para tecnología de Despliegue <strong>pero con Controladores acoplados, poco cohesivos y grano grueso con cada nueva tecnología</strong></span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="yellow">TicTacToe. Solucion. Versión 11.4. <strong>mvp. pm. withProxy</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="yellow">Clases Proxy para Open/Close para nuevas tecnologías de Despliegue</span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top" rowspan="2"><div class="content"><div class="paragraph">
<p><span class="purple">TicTacToe. Requisitos. Versión 5. <strong>Ficheros</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="purple">TicTacToe. Solucion. Versión 12.5. <strong>mvp. pm. withoutDAO</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="purple">Clases Vistas y Controladores para la tecnología de persistencia <strong>pero con Modelos de grano grueso, baja cohesión y alto acoplamiento a tecnologías de persistencia de ficheros</strong></span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="purple">TicTacToe. Solucion. Versión 13.5. <strong>mvp. pm. withDAO</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="purple">Patrón DAO</span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top" rowspan="2"><div class="content"><div class="paragraph">
<p><span class="lime">TicTacToe. Requisitos. Versión 6. <strong>BasesDatos</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="lime">TicTacToe. Solucion. Versión 14.6. <strong>mvp. pm. withoutPrototype</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="lime">Nuevas Vistas y DAOS para la nueva tecnología  <strong>pero con clase Principal acoplada a las tecnologías actuales y futuras de persistencia</strong></span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="lime">TicTacToe. Solucion. Versión 15.6. <strong>mvp. pm. withPrototype</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="lime">Open/Close para arranque con configuración de persistencia</span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top" rowspan="3"><div class="content"><div class="paragraph">
<p><span class="red"><strong>Arquitectura MVC</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top" rowspan="3"><div class="content"><div class="paragraph">
<p><span class="red">TicTacToe. Requisitos. Versión 1. <strong>Básica</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="red">TicTacToe. Solucion. Versión 16.1. <strong>mvp. pv</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="red">Baile de la Triada</span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="red">TicTacToe. Solucion. Versión 17.1. <strong>mvp. sc</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="red">Baile de la Triada</span></p>
</div></div></td>
</tr>
<tr>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="red">TicTacToe. Solucion. Versión 18.1. <strong>mvc</strong></span></p>
</div></div></td>
<td class="tableblock halign-left valign-top"><div class="content"><div class="paragraph">
<p><span class="red">Baile de la Triada</span></p>
</div></div></td>
</tr>
</tbody>
</table>
</div>
</div>
</div>
<div id="footer">
<div id="footer-text">
Version 0.0.1<br>
Last updated 2020-10-04 20:00:35 +0200
</div>
</div>
</html>