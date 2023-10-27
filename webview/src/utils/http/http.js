import {proxyUrl} from '../../config/env'
import axios from 'axios'

export default async (url = '', data = {}, type = 'GET', method = 'fetch') => {
    type = type.toUpperCase();
    url = proxyUrl + url;
    console.log(method, type, url, data)
    if (type === 'GET') {
        await axios.get(url, {params: data}).then(res => {
            console.log(res)
            if (res.data.code === 201) {
                console.log(res.data.data)
                data = res.data.data
            } else {
                throw new Error(res.data)
            }
        }).catch(e => {
            throw new Error(e)
        })
        return data;
    }
    if (type === 'POST') {
        await axios.post(url, data).then(res => {
            if (res.data.code === 201) {
                console.log(res.data.data)
                data = res.data.data
            } else {
                throw new Error(res.data)
            }
        }).catch(e => {
            throw new Error(e)
        })
        return data;
    }
}
