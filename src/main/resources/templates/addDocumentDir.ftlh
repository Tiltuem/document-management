<#import "parts/common.ftlh" as common>
<#import "/spring.ftl" as spring />
<@common.page>
    <section class="about">
        <div class="col-md-12">
            <h1><strong>Отправка документов</strong></h1>
            <p class="right">
                <a class="btn btn-my" href="documents/0">Назад</a>
            </p>
            <form action="/admin/add" method="post" enctype="multipart/form-data">
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
                                <label class="test">Название документа</label>
                                <@spring.formInput "document.name" "required"/>
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
                       <@spring.formInput "document.comment" />
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
                    </div>
                </div>
            </form>
        </div>
        <div id="modal" class="modal" tabindex="-1">
            <div class="modal-dialog modal-dialog-centered" data-bs-config={backdrop:true}>
                <div class="modal-content">
                    <div class="modal-header">
                        <h3>Отправка документа</h3>
                        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body">
                        <h4>Документ успешно отправлен!</h4>
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-outline-dark" data-bs-dismiss="modal">Закрыть</button>
                    </div>
                </div>
            </div>
        </div>
        <script>
            function myFunction() {
                myvariable = ${added?c};
                if (myvariable === true) {
                    $('#modal').modal('show')
                }
            }
        </script>
    </section>
</@common.page>