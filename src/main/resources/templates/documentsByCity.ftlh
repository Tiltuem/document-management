<#import "parts/common.ftlh" as common>
<#import "parts/pagination.ftlh" as p>

<@common.page>
    <section class="about">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h2>Документы</h2>
                    <#if documents.getTotalPages() != 0>
                        <div class="table-responsive">
                            <table class="table table-striped table-bordered table-hover table-sm rounded">
                                <thead>
                                <tr>
                                    <#if itsAdmin??>
                                        <th>Город</th>
                                    </#if>
                                    <th>Наименование</th>
                                    <th>ФИО создателя</th>
                                    <th>Тип документа</th>
                                    <th>Подтип документа</th>
                                    <th>Дата добавления</th>
                                    <th>Дата окончания</th>
                                    <th>Файл</th>
                                    <th>Редактирование</th>
                                </tr>
                                </thead>
                                <tbody>
                                <#list documents.iterator() as document>
                                    <tr>
                                        <#if itsAdmin??>
                                            <td>${document.city}</td>
                                        </#if>
                                        <td>${document.name}</td>
                                        <td>${document.username}</td>
                                        <td>${document.type.getRussianName()}</td>
                                        <td>${document.innerType.russianType}</td>
                                        <td>${document.createdDate}</td>
                                        <td>${document.endDate}</td>
                                        <td>
                                            <button type="submit" class="btn btn-light"
                                                    onclick="location.href='${document.temporaryLink}'">
                                                Загрузить
                                            </button>
                                        </td>
                                        <td>
                                            <form action="/admin/document/upload" method="post"
                                                  enctype="multipart/form-data">
                                                <input type="file" name="fileDoc"/>
                                                <input type="hidden" name="fileName" value="${document.file}">
                                                <button type="submit" class="btn btn-light">
                                                    Подтвердить
                                                </button>
                                            </form>
                                        </td>
                                    </tr>
                                </#list>
                                </tbody>
                            </table>
                        </div>
                        <@p.pagination "admin/documents" documents />
                    <#else>
                        <h3>Документы отсутствуют</h3>
                    </#if>
                </div>
            </div>
        </div>
    </section>
</@common.page>