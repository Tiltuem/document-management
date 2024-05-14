<#import "parts/common.ftlh" as common>
<#import "/spring.ftl" as spring />
<@common.page>
    <section class="about">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2>Отправка документов</h2>
                    <form action="/admin/add" method="post" enctype="multipart/form-data">
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
                                Тип документа:
                            </div>
                            <div class="col-25">
                                <select type="text" name="innerType">
                                    <#list types as type>
                                        <option value="${type}">${type.russianType}</option>
                                    </#list>
                                </select>
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
                                Комментарий:
                            </div>
                            <div class="col-25">
                                <@spring.formInput "document.comment"/>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-25">
                                Дата состовления документа:
                            </div>
                            <div class="col-25">
                                <input type="date" name="startDocument">
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-25">
                                <button type="submit" class="btn btn-my">
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
</@common.page>