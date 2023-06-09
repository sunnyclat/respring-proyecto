-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-06-2023 a las 19:05:44
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.0.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `restspring`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `id` bigint(20) NOT NULL,
  `nombre` varchar(20) DEFAULT NULL,
  `apellido` varchar(20) DEFAULT NULL,
  `email` varchar(20) DEFAULT NULL,
  `password` varchar(300) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`id`, `nombre`, `apellido`, `email`, `password`) VALUES
(3, 'hernan', 'rogelio', 'b@gmail.com', '$argon2id$v=19$m=102'),
(4, 'hernan', 'gomez', 'n@gmail.com', '$argon2id$v=19$m=102'),
(5, 'hernann', 'tyu', 'lgg@gmail.com', '$argon2id$v=19$m=102'),
(6, 'feteiciosss', 'tyuuuuu', 'lggg@gmail.com', '$argon2id$v=19$m=102'),
(7, 'andamio', 'federico', 'm@gmail.com', '$argon2id$v=19$m=102'),
(8, 'susana', 'gonzalez', '', ''),
(9, 'rogelio', 'rogelio', 'kn@gmail.com', '$argon2id$v=19$m=102'),
(10, 'palacio', 'facundo', 'pal@hotmail.com', '$argon2id$v=19$m=102'),
(11, 'sergio', 'fetiche', 'g@gmail.com', '$argon2id$v=19$m=102'),
(12, 'elcio', 'gustazo', 'lghg@gmail.com', '$argon2id$v=19$m=102'),
(13, 'ricardo', 'merengue', 'meren@gmail.com', '$argon2id$v=19$m=102'),
(16, 'hernan', 'usurio', 'her@gmail.com', '$argon2id$v=19$m=1024,t=1,p=1$x3Si9F84Ouw3F0hzRwQiTw$uSiNBClfH8zkHchQTNSLz0IkvpQTciOLkwEdIP3a3tM');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=17;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
