import {baseUrl} from '../../config/env'
import axios from 'axios'

export default async (url = '', data = {}, type = 'GET', method = 'fetch') => {
    type = type.toUpperCase();
    url = baseUrl + url;
    console.log(method, type, url, data)
    if (type === 'GET') {
        await axios.get(url, {params: data}).then(res => {
            if (res.data.message.success === true) {
                console.log(res.data.message)
                data = res.data.message
            } else {
                throw new Error(res.data.message.message)
            }
        }).catch(e => {
            throw new Error(e)
        })
        return data;
    }
    if (type === 'POST') {
        await axios.post(url, data).then(res => {
            if (res.data.message.success === true) {
                console.log(res.data.message)
                data = res.data.message
            } else {
                throw new Error(res.data.message.message)
            }
        }).catch(e => {
            throw new Error(e)
        })
        return data;
    }
}
