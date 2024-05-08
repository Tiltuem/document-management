<#import "parts/common.ftlh" as common>
<#import "/spring.ftl" as spring />

<@common.page>
    <section class="about">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2>Добавление нового документа</h2>
                    <form action="/document/add" method="post" enctype="multipart/form-data">
                        <div class="col-25">
                            Город:
                        </div>
                        <div class="col-75">
                            <@spring.formInput "document.city"/>
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
                        <div class="col-75">
                            <select type="text" name="typeDocument">
                                <#list types as type>
                                    <option value="${type}">${type.russianType}</option>
                                </#list>
                            </select>
                        </div>
                        <div class="col-25">
                            Документ:
                        </div>
                        <div class="col-75">
                            <input type="file" name="fileDoc"/>
                        </div>

                        <button type="submit" class="btn btn-my">
                            Сохранить
                        </button>
                    </form>
                </div>
            </div>
        </div>
    </section>
</@common.page>