<#macro page>
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
        <link rel="stylesheet" href="../../css/footer.css">
        <link rel="stylesheet" href="../../css/header.css">
    </head>
    <body onload="myFunction()">
    <#--Шапка-->
    <div class="wrapper">
        <header>
            <a href="https://fly-pro.ru/" class="t228__imgwrapper" style="color:#ffffff;"><img class="t228__imglogo "
                                                                                               src="https://static.tildacdn.com/tild6639-6139-4638-a639-363939386131/logo_PNG_2_14.png"
                                                                                               imgfield="img"
                                                                                               style="max-height: 80px"
                                                                                               alt="Company"></a>
            <nav>
                <a class="t-menu__link-item t-menusub__target-link" href="https://fly-pro.ru/" aria-expanded="false"
                   role="button" data-menu-submenu-hook="link_sub1_396274701" data-menu-item-number="1"
                   style="color:#000000;font-size:20px;font-weight:400;font-family:'BebasNeue';"
                   data-tooltip-menu-id="396274701">Главная</a>
                <a class="t-menu__link-item" href="https://fly-pro.ru/casting" data-menu-submenu-hook=""
                   data-menu-item-number="2"
                   style="color:#000000;font-size:20px;font-weight:400;font-family:'BebasNeue';">Кастинги</a>
                <a class="t-menu__link-item" href="https://fly-pro.ru/education" data-menu-submenu-hook=""
                   data-menu-item-number="3"
                   style="color:#000000;font-size:20px;font-weight:400;font-family:'BebasNeue';">Программа</a>
                <a class="t-menu__link-item" href="https://fly-pro.ru/models" data-menu-submenu-hook=""
                   data-menu-item-number="4"
                   style="color:#000000;font-size:20px;font-weight:400;font-family:'BebasNeue';">Модели</a>
                <a class="t-menu__link-item" href="https://fly-pro.ru/contacts" data-menu-submenu-hook=""
                   data-menu-item-number="5"
                   style="color:#000000;font-size:20px;font-weight:400;font-family:'BebasNeue';">Контакты</a>
            </nav>
            <div class="col-md-6 right">
                <div>Россия +7 (916) 783-61-16
                    <br>
                    Пн-Пт с 8:00 до 18:00 Мск
                </div>
            </div>
            <div class="follow-us-three">
                <a href="https://vk.com/flyproduction_official" target="_blank" rel="nofollow noopener" aria-label="vk"
                   style="width: 30px; height: 30px;">
                    <svg class="t-sociallinks__svg" role="presentation" width="30px" height="30px" viewBox="0 0 100 100"
                         fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd"
                              d="M50 100c27.614 0 50-22.386 50-50S77.614 0 50 0 0 22.386 0 50s22.386 50 50 50ZM25 34c.406 19.488 10.15 31.2 27.233 31.2h.968V54.05c6.278.625 11.024 5.216 12.93 11.15H75c-2.436-8.87-8.838-13.773-12.836-15.647C66.162 47.242 71.783 41.62 73.126 34h-8.058c-1.749 6.184-6.932 11.805-11.867 12.336V34h-8.057v21.611C40.147 54.362 33.838 48.304 33.556 34H25Z"
                              fill="#53897b"></path>
                    </svg>
                </a>
                <a href="https://www.instagram.com/flyproduction_official/" target="_blank" rel="nofollow noopener"
                   aria-label="instagram" style="width: 30px; height: 30px;">
                    <svg class="t-sociallinks__svg" role="presentation" width="30px" height="30px" viewBox="0 0 100 100"
                         fill="none" xmlns="http://www.w3.org/2000/svg">
                        <path fill-rule="evenodd" clip-rule="evenodd"
                              d="M50 100C77.6142 100 100 77.6142 100 50C100 22.3858 77.6142 0 50 0C22.3858 0 0 22.3858 0 50C0 77.6142 22.3858 100 50 100ZM25 39.3918C25 31.4558 31.4566 25 39.3918 25H60.6082C68.5442 25 75 31.4566 75 39.3918V60.8028C75 68.738 68.5442 75.1946 60.6082 75.1946H39.3918C31.4558 75.1946 25 68.738 25 60.8028V39.3918ZM36.9883 50.0054C36.9883 42.8847 42.8438 37.0922 50.0397 37.0922C57.2356 37.0922 63.0911 42.8847 63.0911 50.0054C63.0911 57.1252 57.2356 62.9177 50.0397 62.9177C42.843 62.9177 36.9883 57.1252 36.9883 50.0054ZM41.7422 50.0054C41.7422 54.5033 45.4641 58.1638 50.0397 58.1638C54.6153 58.1638 58.3372 54.5041 58.3372 50.0054C58.3372 45.5066 54.6145 41.8469 50.0397 41.8469C45.4641 41.8469 41.7422 45.5066 41.7422 50.0054ZM63.3248 39.6355C65.0208 39.6355 66.3956 38.2606 66.3956 36.5646C66.3956 34.8687 65.0208 33.4938 63.3248 33.4938C61.6288 33.4938 60.2539 34.8687 60.2539 36.5646C60.2539 38.2606 61.6288 39.6355 63.3248 39.6355Z"
                              fill="#53897b"></path>
                    </svg>
                </a>
            </div>
        </header>
        <#--Тело-->
        <#nested>
        <#--Подвал-->
        <footer id="footer">
            <div class="container">
                <div class="row">
                    <div class="col-md-3">
                        <div class="logo">
                            <img src="../../css/image/logo.png" alt="FLY PRODUCTION">
                        </div>
                    </div>
                    <div class="col-md-2">
                        <ul>
                            <li><a href="#">Главная</a></li>
                            <br>
                            <li><a href="#">Кастинги</a></li>
                            <br>
                            <li><a href="#">Контакты</a></li>
                            <br>
                            <li><a href="#">Модели</a></li>
                        </ul>
                    </div>
                    <div class="col-md-4">
                        <ul>
                            <li>Россия +7 (916) 783-61-16</li>
                            <br>
                            <li>Пн-Пт с 8:00 до 18:00 Мск</li>
                            <br>
                            <li>INFO@FLY-PRO.RU</li>
                            <br>
                            <li><img src="../../css/image/inst_footer.png"
                                     onclick="location.href='https://www.instagram.com/flyproduction_official/'"> <img
                                        src="../../css/image/tt_footer.png" onclick="location.href=''"> <img
                                        src="../../css/image/vk_footer.png"
                                        onclick="location.href='https://vk.com/flyproduction_official'"></li>
                        </ul>
                    </div>
                    <div class="col-md-3">
                        <p>&copy; 2019-2023 FLY PRODUCTION</p>
                        <div class="info-item">
                            <a href="#">Политика конфиденциальности</a>
                        </div>
                    </div>
                </div>
            </div>
        </footer>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz"
            crossorigin="anonymous">
    </script>
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        $(".form__input").click(function () {
            if (($(this).prop("checked"))) {
                $("#form__button").removeAttr("disabled");
            } else {
                $("#form__button").attr("disabled", "disabled");
            }
        })
        $('.input-file input[type=file]').on('change', function () {
            let file = this.files[0];
            $(this).next().html(file.name);
        });
    </script>
    </body>
    </html>
</#macro>