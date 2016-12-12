<!DOCTYPE html>
<html lang="en">

<head>
    <#include "header.ftl">
    <!-- calendar -->
    <#if text=="Share Travel Stories">
        <link rel="stylesheet" href="../stylesheets/calendar/pikaday.css">
        <script src="../js/pikaday.js"></script>
        <script type="text/javascript" src="../js/editNotes.js"></script>
    </#if>

</head>

<body>
    <#include "nav.ftl">
    <br>
    <#if text == "Share Travel Stories">
        <#include "editNotes.ftl">
    <#elseif text == "Destination">
        <#include "destination.ftl">
    <#elseif text == "Stories In Time">
        <#include "travelNotes.ftl">
    </#if>
    <script type="text/javascript">
    </script>
</body>

</html>
