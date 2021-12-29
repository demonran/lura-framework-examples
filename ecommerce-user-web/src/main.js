import { createApp } from 'vue'
import App from './App.vue'
import ElementPlus from 'element-plus'
import * as ElementPlusIcon from '@element-plus/icons-vue'
import 'element-plus/dist/index.css'
import './index.css'

import router from './router'

const app = createApp(App)

app.use(ElementPlus)

for(let iconName in ElementPlusIcon) {
    app.component(transElIconName(iconName), ElementPlusIcon[iconName])
}
app.use(router)
app.mount('#app')


export function transElIconName(iconName) {
    return 'i' + iconName.replace(/[A-Z]/g, (match) => '-' + match.toLowerCase())
}
