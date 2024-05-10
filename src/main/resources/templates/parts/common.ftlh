<#macro page>
    <html>
    <head>
        <meta charset="UTF-8"/>
        <title>FLY PRODUCTION</title>
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
        <link rel="stylesheet"
              href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
        <link rel="shortcut icon" href="../../css/image/doc.png">
        <link rel="stylesheet" href="../../css/styleBody.css">
        <link rel="stylesheet" href="../../css/styleButton.css">
        <link rel="stylesheet" href="../../css/styleDirectories.css">
    </head>
    <body>
    <#--Шапка-->
    <header>
        <div class="container">
            <div class="row">
                <div class="col-md-auto">
                    <div class="header-icon"><i class="bi bi-file-earmark-medical"></i></div>
                </div>
                <div class="col">
                    <h1 class="text-white">FLY PRODUCTION</h1>
                </div>
                <div class="col-md-auto">
                    <a class="btn btn-outline-light" href="/admin/documents/0">Главная</a>
                </div>
                <div class="col-md-auto">
                    <a class="btn btn-outline-light" href="/logout">Выйти</a>
                </div>
            </div>
        </div>
    </header>
    <#--Тело-->
    <#nested>
    <#--Подвал-->
    <footer id="footer">
        <div class="container">
            <div class="row">
                <div class="col-12 text-center">
                    <a class="btn btn-outline-light" target="_blank" href=""><i
                                class="bi bi-bootstrap"></i></a>
                    <a class="btn btn-outline-light" target="_blank" href=""><i
                                class="bi bi-envelope-at"></i></a>
                </div>
            </div>
        </div>
    </footer>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous">
    </script>
    </body>
    </html>
</#macro>