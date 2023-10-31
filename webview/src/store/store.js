import Vue from 'vue';
import Vuex from 'vuex';
import App from './App.vue';

Vue.use(Vuex);

const store = new Vuex.Store({
    state: {
        token: null
    },
    getter: {

    },
    mutations: {
        setToken(state, token) {
            state.token = token;
        }
    },
    actions: {

    },
    modules: {
        "true": {
            // namespaced为true，则在使用mutations时，就必须要加上模块名
            namespaced: true,
            state: {},
            getters: {},
            mutations: {},
            actions: {},
            modules: {}
        },
        "false": {
            // namespaced不写，默认为false，则在使用mutations时，不需要加模块名
            state: {},
            getters: {},
            mutations: {},
            actions: {},
            modules: {}
        }
    }
});

createApp(App).use(store).mount('#app');
