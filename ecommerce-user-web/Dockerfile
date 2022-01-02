FROM node:15 as builder
WORKDIR /app
# 提前安装依赖， 避免每次安装依赖花很久时间
# 只要 package.json 不修改就会用 docker cache
COPY package.json /app
RUN --mount=type=cache,target=/app/node_modules,id=my_app_npm_module,sharing=locked \
    --mount=type=cache,target=/root/.npm,id=npm_cache \
      yarn install --registry=https://registry.npm.taobao.org/

ADD . /app
RUN  --mount=type=cache,target=/app/node_modules,id=my_app_npm_module,sharing=locked \
     yarn build

FROM nginx
COPY --from=builder /app/dist /usr/share/nginx/html
COPY nginx/default.conf /etc/nginx/conf.d
