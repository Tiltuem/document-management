<#import "parts/common.ftlh" as common>
<#import "/spring.ftl" as spring />
<html xmlns="http://www.w3.org/1999/html">
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
                <h2>Отправка документов</h2>
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
                            <select type="text" name="city" required>
                                <option value="Самара">Самара</option>
                                <option value="Москва">Москва</option>
                                <option value="Уфа">Уфа</option>
                                <option value="Оренбург">Оренбург</option>
                                <option value="Челябинск">Челябинск</option>
                                <option value="Пермь">Пермь</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-25">
                            Тип документа:
                        </div>
                        <div class="col-25">
                            <select type="text" name="passportType" required>
                                <option value="Паспорт РФ">Паспорт РФ</option>
                                <option value="Паспорт иностранного гражданина">Паспорт иностранного гражданина</option>
                            </select>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-25">
                            Серия:
                        </div>
                        <div class="col-25">
                            <@spring.formInput "document.passportSeries"/>
                        </div>
                        <div class="col-25">
                            Номер:
                        </div>
                        <div class="col-25">
                            <@spring.formInput "document.passportNumber"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-25">
                            Кем выдан:
                        </div>
                        <div class="col-25">
                            <@spring.formInput "document.passportByWhom"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-md-12">
                            Скан документа:
                        </div>
                        <div class="col-md-3">
                            <input class="form-control" type="file" id="formFile" name="fileDoc" required>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-25">
                            Номер телефона:
                        </div>
                        <div class="col-25">
                            <@spring.formInput "document.phoneNumber"/>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-25">
                            Email:
                        </div>
                        <div class="col-25">
                            <input type="email" id="email" name="email" required>
                        </div>
                    </div>

                    <div class="row">
                        <div class="col-25">
                            Дата окончания действия договора:
                        </div>
                        <div class="col-25">
                            <input type="date" name="endDocument" required>
                        </div>
                    </div>

                    <a target="_blank" href="">Договор на оказание консультационных услуг</a><br>
                    <input type="checkbox" class="form__input">Я, согласен с <a target="_blank" href="https://fly-pro.ru/privacypolicy">политикой конфидинциальности</a>
                    <div class="row">
                        <div class="col-25">
                            <button type="submit" class="btn btn-my" disabled id="form__button">
                                Сохранить
                            </button>
                        </div>
                        <div class="col-md-3">
                            <#if added>
                                <h4>Документ успешно добавлен</h4>
                            </#if>
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
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(".form__input").click(function() {
        if (($(this).prop("checked"))) {
            $("#form__button").removeAttr("disabled");
        } else {
            $("#form__button").attr("disabled", "disabled");
        }
    })
</script>
</body>
</html>

