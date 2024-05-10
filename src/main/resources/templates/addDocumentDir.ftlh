<#import "parts/common.ftlh" as common>
<#import "/spring.ftl" as spring />
<@common.page>
    <section class="about">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2>Добавление нового документа</h2>
                    <form action="/admin/add" method="post" enctype="multipart/form-data">
                        <div class="col-25">
                            Ваше ФИО:
                        </div>
                        <div class="col-75">
                            <@spring.formInput "document.username"/>
                        </div>
                        <div class="col-25">
                            Дата окончания:
                        </div>
                        <div class="col-75">
                            <input type="date" name="endDocument">
                        </div>
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
                        <input class="form-control" type="file" id="formFile" name="fileDoc">
                        <p class="right">
                            <button type="submit" class="btn btn-my">
                                Сохранить
                            </button>
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </section>
</@common.page>