import {computed, inject, onMounted, provide, reactive, ref} from "vue";

const CRUD = {}


CRUD.STATUS = {
    NORMAL: 0,
    PREPARED: 1,
    PROCESSING: 2
}


export function useCrudProvider(options)  {


    const defaultOptions = {
        // CRUD Method
        crudMethod: {
            add: (form) => {},
            del: (id) => {},
            edit: (form) => {},
            get: (id) => {},
            list: () => {}
        }
    }

    options = Object.assign( defaultOptions, options)

    const status = reactive({
        add: CRUD.STATUS.NORMAL,
        edit: CRUD.STATUS.NORMAL,
        get cu () {
            if (this.add === CRUD.STATUS.NORMAL && this.edit === CRUD.STATUS.NORMAL) {
                return CRUD.STATUS.NORMAL
            } else if (this.add === CRUD.STATUS.PREPARED || this.edit === CRUD.STATUS.PREPARED) {
                return CRUD.STATUS.PREPARED
            } else if (this.add === CRUD.STATUS.PROCESSING || this.edit === CRUD.STATUS.PROCESSING) {
                return CRUD.STATUS.PROCESSING
            }
        }
    })


    const data = ref([])
    let form = reactive({})


    onMounted(() => refresh())

    const toEdit = (data) => {
        status.edit = CRUD.STATUS.PREPARED
        options.crudMethod.get({id: data.id}).then(res => Object.assign(form, res))
    }
    const toAdd = () => {
        status.add = CRUD.STATUS.PREPARED
    }

    const cancelCU = () => {
        status.add = CRUD.STATUS.NORMAL
        status.edit = CRUD.STATUS.NORMAL
    }

    const doDelete = (data) => {
        status.del = CRUD.STATUS.PROCESSING
        options.crudMethod.del({id: data.id}).then(res => {
            status.del = CRUD.STATUS.NORMAL
            refresh()
        })
    }

    const refresh = () => {
        options.crudMethod.list().then(res => data.value = res)
    }

    const doAdd = () => {
        options.crudMethod.add(form).then(res => {
            status.add = CRUD.STATUS.NORMAL
            refresh()
        })
    }

    const doEdit = () => {
        status.edit = CRUD.STATUS.PROCESSING
        options.crudMethod.edit(form).then(res => {
            status.edit = CRUD.STATUS.NORMAL
            refresh()
        })
    }

    const submitCU = () => {
        if (crud.status.add === CRUD.STATUS.PREPARED) {
            doAdd()
        } else if (crud.status.edit === CRUD.STATUS.PREPARED) {
            doEdit()
        }
    }
    const crud = reactive({
        status,
        toEdit,
        toAdd,
        cancelCU,
        submitCU,
        doDelete,
        data,
        form,
        refresh
    })
    provide('crud', crud)
    return crud

}



export const useCrud = function () {
    return inject('crud')
}






