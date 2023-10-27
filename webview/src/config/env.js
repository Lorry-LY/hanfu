/**
 * 配置编译环境和线上环境之间的切换
 *
 * baseUrl: 域名地址
 * routerMode: 路由模式
 * baseImgPath: 图片存放地址
 *
 */
let baseUrl = '';
let proxyUrl = '';
let routerMode = 'hash';
let baseImgPath;

if (process.env.NODE_ENV == 'development') {
    baseUrl = 'http://127.0.0.1:9999';
    proxyUrl = '/development';
    baseImgPath = '/file/img/';
} else {
    baseUrl = 'http://114.132.232.157';
    proxyUrl = '/product';
    baseImgPath = '/file/img/';
}

export {
    baseUrl,
    proxyUrl,
    routerMode,
    baseImgPath
}
