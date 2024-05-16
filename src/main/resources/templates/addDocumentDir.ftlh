<#import "parts/common.ftlh" as common>
<#import "/spring.ftl" as spring />
<@common.page>
    <section class="about">
        <div class="col-md-12">
            <h1><strong>Отправка документов</strong></h1>
            <form action="/admin/add" method="post" enctype="multipart/form-data">
                <br>
                <div class="bord">
                    <div class="my-text">
                            <span>
                                <label class="test">ФИО</label>
                                <@spring.formInput "document.username"/>
                            </span>
                    </div>
                </div>
                <br>
                <div class="bord">
                    <div class="my-text">
                            <span>
                                <label class="test">Тип<br>документа</label>
                                <select type="text" name="innerType">
                                    <#list types as type>
                                        <option value="${type}">${type.russianType}</option>
                                    </#list>
                                </select>
                            </span>
                    </div>
                </div>
                <br>
                <div class="bord">
                    <div class="my-text">
                    <span>
                        <label class="test">Документ</label>
                        <label class="input-file"><input type="file" id="formFile" name="fileDoc"
                                                         required><span>Upload</span></label>
                    </span>
                    </div>
                </div>
                <br>
                <div class="bord">
                    <div class="my-text">
                    <span>
                        <label class="test">Комментарий</label>
                       <@spring.formInput "document.comment"/>
                    </span>
                    </div>
                </div>
                <br>
                <div class="bord">
                    <div class="my-text">
                            <span>
                                <label class="test">Дата состовления<br>документа</label>
                                <input type="date" name="startDocument" required>
                            </span>
                    </div>
                </div>
                <br>
                <div class="row">
                    <div class="col-25">
                        <button type="submit" class="btn btn-my">
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