<#import "parts/common.ftlh" as common>
<#import "/spring.ftl" as spring />
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
        </div>
    </div>
</header>
<#--Тело-->
<section class="about">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <h2>Добавление нового документа</h2>
                <form action="/user/add" method="post" enctype="multipart/form-data">
                    <div class="row">
                        <div class="col-25">
                            Ваше ФИО:
                        </div>
                        <div class="col-75">
                            <@spring.formInput "document.username"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            Город:
                        </div>
                        <div class="col-75">
                            <@spring.formInput "document.city"/>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            Тип документа:
                        </div>
                        <div class="col-25">
                            <select type="text" name="typeDocument">
                                <#list types as type>
                                    <option value="${type}">${type.russianType}</option>
                                </#list>
                            </select>
                        </div>

                        <div class="col-25">
                            Дата окончания:
                        </div>
                        <div class="col-25">
                            <input type="date" name="endDocument" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            Файл:
                        </div>
                        <div class="col-25">
                            <input class="form-control" type="file" id="formFile" name="fileDoc" required>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-25">
                            <button type="submit" class="btn btn-my">
                                Сохранить
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
    </div>
</section>
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

