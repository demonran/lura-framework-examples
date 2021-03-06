import vue from '@vitejs/plugin-vue'
import { defineConfig, loadEnv } from 'vite'
import AutoImport from 'unplugin-auto-import/vite'
import Components from 'unplugin-vue-components/vite'
import {ElementPlusResolver} from 'unplugin-vue-components/resolvers'

const path = require('path')
console.log(path.resolve(__dirname, './src'))

export default ({ mode }) => defineConfig({
    plugins: [
        vue(),
        // ...
        AutoImport({
            resolvers: [ElementPlusResolver()],
        }),
        Components({
            resolvers: [ElementPlusResolver()],
        }),
    ],

    server: {
        proxy: {
            // 选项写法
            '/api': {
                target: loadEnv(mode, process.cwd()).VITE_APP_BASE_API, // 所要代理的目标地址
                // rewrite: path => path.replace(/^\/api/, ''), // 重写传过来的path路径，比如 `/api/index/1?id=10&name=zs`（注意:path路径最前面有斜杠（/），因此，正则匹配的时候不要忘了是斜杠（/）开头的；选项的 key 也是斜杠（/）开头的）
                changeOrigin: true,  // true/false, Default: false - changes the origin of the host header to the target URL
            }
        }
    },


    resolve: {
        alias: {
            "@": "/src",
            // '/@components/': path.resolve(__dirname, './src/components')
        },
        // 忽略后缀名的配置选项, 添加 .vue 选项时要记得原本默认忽略的选项也要手动写入
        extensions: ['.mjs', '.js', '.ts', '.jsx', '.tsx', '.json', '.vue']
    }

})
