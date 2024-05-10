<#import "parts/common.ftlh" as common>
<#import "parts/pagination.ftlh" as p>

<@common.page>
    <section class="about">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="row">
                        <h2>Документы</h2>
                        <#if !itsAdmin>
                            <p class="right">
                                <a class="btn btn-my" href="/admin/new">Добавить документ</a>
                            </p>
                        </#if>
                    </div>
                    <#if documents.getTotalPages() != 0>
                        <form action="/admin/documents/${page}-search" method="get">
                            <div class="search">
                                <input placeholder="Введите ФИО" type="text" name="name">
                                <button type="submit">Поиск
                                </button>
                            </div>
                            <br>
                            <br>
                            <select name="columnDate" class="btn btn-outline-light">
                                <option disabled>Выберите параметр</option>
                                <option value="createdDate">Дата добавления</option>
                                <option value="endDate">Дата окончания</option>
                            </select>
                            с  <input type="date" name="dateFrom">
                            по <input type="date" name="dateBy" value="">
                            <#if search>
                                <br>
                                <br>
                                <a class="btn btn-my" href="/admin/documents/0">Отменить поиск</a>
                            </#if>
                        </form>
                        <div class="table-responsive">
                            <table class="table  table-sm rounded">
                                <thead>
                                <tr>
                                    <#if itsAdmin>
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
                                        <#if itsAdmin>
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
                                                <div class="mb-1">
                                                    <input class="form-control" type="file" id="formFile" name="fileDoc">
                                                </div>
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
                        <#if search>
                            <br>
                            <br>
                            <a class="btn btn-my" href="/admin/documents/0">Отменить поиск</a>
                        </#if>
                    </#if>
                </div>
            </div>
        </div>
    </section>
</@common.page>