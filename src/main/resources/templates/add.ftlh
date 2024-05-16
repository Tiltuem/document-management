<#import "parts/common.ftlh" as common>
<#import "/spring.ftl" as spring />

<@common.page>
<section class="about">
    <div class="col-md-12">
        <h1><strong>Подписание договора</strong></h1>
        <form action="/user/add" method="post" enctype="multipart/form-data">
            <br>
            <div class="bord">
                <div class="my-text">
                            <span>
                                <label class="test">ФИО</label>
                                <@spring.formInput "document.username" "required"/>
                            </span>
                </div>
            </div>
            <br>
            <div class="bord">
                <div class="my-text">
                            <span>
                                <label class="test">Город</label>
                               <select type="text" name="city" required>
                                <option value="Самара">Самара</option>
                                <option value="Москва">Москва</option>
                                <option value="Уфа">Уфа</option>
                                <option value="Оренбург">Оренбург</option>
                                <option value="Челябинск">Челябинск</option>
                                <option value="Пермь">Пермь</option>
                            </select>
                            </span>
                </div>
            </div>
            <br>
            <div class="bord">
                <div class="my-text">
                            <span>
                                <label class="test">Тип<br>документа</label>
                                <select type="text" name="passportType" required>
                                <option value="Паспорт РФ">Паспорт РФ</option>
                                <option value="Паспорт иностранного гражданина">Паспорт иностранного гражданина</option>
                                </select>
                            </span>
                </div>
            </div>
            <br>
            <div class="bord">
                <div class="my-text">
                            <span>
                                <label class="test">Серия</label>
                                <@spring.formInput "document.passportSeries" "required"/>
                            </span>
                </div>
            </div>
            <br>
            <div class="bord">
                <div class="my-text">
                            <span>
                                <label class="test">Номер</label>
                                 <@spring.formInput "document.passportNumber" "required"/>
                            </span>
                </div>
            </div>
            <br>
            <div class="bord">
                <div class="my-text">
                            <span>
                                <label class="test">Кем выдан</label>
                                <@spring.formInput "document.passportByWhom" "required"/>
                            </span>
                </div>
            </div>
            <br>
            <div class="bord">
                <div class="my-text">
                            <span>
                                <label class="test">Название документа</label>
                                <@spring.formInput "document.name" "required"/>
                            </span>
                </div>
            </div>
            <br>
            <div class="bord">
                <div class="my-text">
                    <span>
                        <label class="test">Подтверждающий документ</label>
                        <label class="input-file"><input type="file" id="formFile" name="fileDoc"
                                                         required><span>Upload</span></label>
                    </span>
                </div>
            </div>
            <br>
            <div class="bord">
                <div class="my-text">
                            <span>
                                <label class="test">Номер телефона</label>
                                <@spring.formInput "document.phoneNumber"/>
                            </span>
                </div>
            </div>
            <br>
            <div class="bord">
                <div class="my-text">
                            <span>
                                <label class="test">Email</label>
                                <input type="email" id="email" name="email" required>
                            </span>
                </div>
            </div>
            <br>
            <div class="bord">
                <div class="my-text">
                            <span>
                                <label class="test">Дата окончания<br>действия договора</label>
                                <input type="date" name="endDocument" required>
                            </span>
                </div>
            </div>
            <br>
            <a target="_blank" href="" style="color: #000000">Договор на оказание консультационных услуг</a><br><br>
            <input type="checkbox" class="form__input">Я, согласен с <a target="_blank"
                                                                        href="https://fly-pro.ru/privacypolicy"
                                                                        style="color: #000000">политикой
                конфидинциальности</a><br><br>
            <div class="row">
                <div class="col-25">
                    <button type="submit" class="btn btn-my"  disabled id="form__button">
                        Отправить
                    </button>
                    <#if added>
                       Документ успешно добавлен
                    </#if>
                </div>
            </div>
        </form>
    </div>

</section>
</@common.page>