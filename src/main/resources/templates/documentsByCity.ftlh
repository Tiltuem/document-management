<#import "parts/common.ftlh" as common>
<#import "parts/pagination.ftlh" as p>

<@common.page>
    <section class="about">
        <div class="col-md-12">
            <div class="row">
                <h1><strong>Документы</strong></h1>
                <#if !itsAdmin>
                    <p class="right">
                        <a class="btn btn-my" href="/admin/new">Добавить документ</a>
                    </p>
                </#if>
                <p class="right">
                    <a class="btn btn-my" href="/logout">Выйти</a>
                </p>
            </div>
            <#if documents.getTotalPages() != 0>
                <form action="/admin/documents/${page}-search" method="get">
                    <div class="search">
                        <input placeholder="Введите ФИО" type="text" name="username">
                        <input placeholder="Введите название" type="text" name="name">
                        <#if itsAdmin>
                            <input placeholder="Введите город" type="text" name="city">
                        <#else>
                            <input type="hidden" name="city" value="${city}">
                        </#if>
                        <button type="submit">Поиск
                        </button>
                    </div>
                    <br>
                    <br>
                    <select name="type" class="btn btn-outline-dark">
                        <option value="">Тип документа</option>
                        <option value="INTERNAL">Внутрифирменные документы</option>
                        <option value="EXTERNAL">Входящие и исходящие документы</option>
                    </select>
                    <select name="innerType" class="btn btn-outline-dark">
                        <option value="">Подтип документа</option>
                        <option value="Чеки">Чеки</option>
                        <option value="Агентские договора">Агентские договора</option>
                        <option value="Письменные соглашения">Письменные соглашения</option>
                    </select>
                    <br>
                    <br>
                    <select name="columnDate" class="btn btn-outline-dark">
                        <option value="createdDate">Дата добавления</option>
                        <option value="endDate">Дата окончания</option>
                    </select>
                    с <input type="date" name="dateFrom">
                    по <input type="date" name="dateBy" value="">
                    <#if search>
                        <br>
                        <br>
                        <a class="btn btn-my" href="/admin/documents/0">Отменить поиск</a>
                    </#if>
                </form>
                <br>
                <div class="table-responsive">
                    <table class="table  rounded">
                        <thead>
                        <tr>
                            <#if itsAdmin>
                                <th>Город</th>
                            </#if>
                            <th>Наименование</th>
                            <th>ФИО создателя</th>
                            <th>Данные паспорта</th>
                            <th>Контакты</th>
                            <th>Тип документа</th>
                            <th>Подтип документа</th>
                            <th>Комментарий</th>
                            <th>Дата занесения в АИС</th>
                            <th>Дата составления</th>
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
                                <td>
                                    <#if document.passportType??>
                                        ${document.passportType}<br>${document.passportSeries}-${document.passportNumber}<br>${document.passportByWhom}
                                    <#else>
                                        -
                                    </#if>
                                </td>
                                <td>
                                    <#if document.phoneNumber??>
                                        ${document.phoneNumber}<br>${document.email}
                                    <#else>
                                        -
                                    </#if>
                                </td>
                                <td>${document.type.getRussianName()}</td>
                                <td>
                                    <#if document.innerType??>
                                        ${document.innerType.russianType}
                                    <#else>
                                        -
                                    </#if>
                                </td>
                                <td>
                                    <#if document.comment??>
                                        ${document.comment}
                                    <#else>
                                        -
                                    </#if>
                                </td>
                                <td>${document.createdDate}</td>
                                <td>
                                    <#if document.startDate??>
                                        ${document.startDate}
                                    <#else>
                                        -
                                    </#if>
                                </td>
                                <td>
                                    <#if document.endDate??>
                                        ${document.endDate}
                                    <#else>
                                        -
                                    </#if>
                                </td>
                                <td>
                                    <button type="submit" class="btn btn-outline-dark"
                                            onclick="location.href='${document.temporaryLink}'">
                                        Загрузить
                                    </button>
                                </td>
                                <td>
                                    <form action="/admin/document/upload" method="post"
                                          enctype="multipart/form-data">
                                        <label class="input-file"><input type="file" id="formFile" name="fileDoc"><span>Upload</span></label>
                                        <input type="hidden" name="fileName" value="${document.file}">
                                        <button type="submit" class="btn btn-outline-dark">
                                            Подтвердить
                                        </button>
                                    </form>
                                </td>
                            </tr>
                        </#list>
                        </tbody>
                    </table>
                </div>
                <@p.pagination "admin/documents" documents/>
            <#else>
                <h3>Документы отсутствуют</h3>
                <#if search>
                    <br>
                    <br>
                    <a class="btn btn-my" href="/admin/documents/0">Отменить поиск</a>
                </#if>
            </#if>
        </div>
    </section>
</@common.page>