const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true,

  devServer: {  
    proxy: {  
      "/development": {  
        target: "http://127.0.0.1:9999",  
        changeOrigin: true,  
        pathRewrite: {  
          '^/development': ''
        }  
      },
      "/product": {  
        target: "http://114.132.232.157",  
        changeOrigin: true,  
        pathRewrite: {  
          '^/product': ''
        }  
      } 
    }  
  }  

})
