import {proxyUrl} from '../../config/env'
import axios from 'axios'
let myToken = null;

export default async (url = '', data = {}, type = 'GET', method = 'fetch') => {
    type = type.toUpperCase();
    url = proxyUrl + url;
    const config = {
        headers:{}
    };
    if (myToken&&myToken!="")config.headers.token = myToken;
    console.log(method, type, url, data)
    if (type === 'GET') {
        await axios.get(url, {
            params: data,
            ...config
        }).then(res => {
            console.log(res)
            if (res.status === 200){
                let body = res.data;
                if (!body.data)throw new Error(body);
                data = body.data;
                if (data.token){
                    let token = data.token;
                    delete data.token;
                    myToken = token;
                    console.log("mytoken:",myToken);
                }
            }else throw new Error(res);
        }).catch(e => {
            console.log(e);
            return null;
        })
        return data;
    }
    if (type === 'POST') {
        await axios.post(url, data,{
                ...config
            }).then(res => {
            console.log(res)
            if (res.status === 200){
                let body = res.data;
                if (!body.data)throw new Error(body);
                data = body.data;
                if (data.token){
                    let token = data.token;
                    delete data.token;
                    myToken = token;
                    console.log("mytoken:",myToken);
                }
            }else throw new Error(res);
        }).catch(e => {
            console.log(e);
            return null;
        })
        return data;
    }
}
