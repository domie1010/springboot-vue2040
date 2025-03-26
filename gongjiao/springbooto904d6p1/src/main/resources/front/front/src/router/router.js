import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import payList from '../pages/pay'

import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import xianluList from '../pages/xianlu/list'
import xianluDetail from '../pages/xianlu/detail'
import xianluAdd from '../pages/xianlu/add'
import checiList from '../pages/checi/list'
import checiDetail from '../pages/checi/detail'
import checiAdd from '../pages/checi/add'
import gongjiaoxianluList from '../pages/gongjiaoxianlu/list'
import gongjiaoxianluDetail from '../pages/gongjiaoxianlu/detail'
import gongjiaoxianluAdd from '../pages/gongjiaoxianlu/add'
import gongjiaozhandianList from '../pages/gongjiaozhandian/list'
import gongjiaozhandianDetail from '../pages/gongjiaozhandian/detail'
import gongjiaozhandianAdd from '../pages/gongjiaozhandian/add'
import gongjiaoxinxiList from '../pages/gongjiaoxinxi/list'
import gongjiaoxinxiDetail from '../pages/gongjiaoxinxi/detail'
import gongjiaoxinxiAdd from '../pages/gongjiaoxinxi/add'
import zhoubianfuwuList from '../pages/zhoubianfuwu/list'
import zhoubianfuwuDetail from '../pages/zhoubianfuwu/detail'
import zhoubianfuwuAdd from '../pages/zhoubianfuwu/add'
import gongjiaodongtaiList from '../pages/gongjiaodongtai/list'
import gongjiaodongtaiDetail from '../pages/gongjiaodongtai/detail'
import gongjiaodongtaiAdd from '../pages/gongjiaodongtai/add'
import newstypeList from '../pages/newstype/list'
import newstypeDetail from '../pages/newstype/detail'
import newstypeAdd from '../pages/newstype/add'
import aboutusList from '../pages/aboutus/list'
import aboutusDetail from '../pages/aboutus/detail'
import aboutusAdd from '../pages/aboutus/add'
import systemintroList from '../pages/systemintro/list'
import systemintroDetail from '../pages/systemintro/detail'
import systemintroAdd from '../pages/systemintro/add'
import discussgongjiaoxianluList from '../pages/discussgongjiaoxianlu/list'
import discussgongjiaoxianluDetail from '../pages/discussgongjiaoxianlu/detail'
import discussgongjiaoxianluAdd from '../pages/discussgongjiaoxianlu/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'pay',
					component: payList,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'xianlu',
					component: xianluList
				},
				{
					path: 'xianluDetail',
					component: xianluDetail
				},
				{
					path: 'xianluAdd',
					component: xianluAdd
				},
				{
					path: 'checi',
					component: checiList
				},
				{
					path: 'checiDetail',
					component: checiDetail
				},
				{
					path: 'checiAdd',
					component: checiAdd
				},
				{
					path: 'gongjiaoxianlu',
					component: gongjiaoxianluList
				},
				{
					path: 'gongjiaoxianluDetail',
					component: gongjiaoxianluDetail
				},
				{
					path: 'gongjiaoxianluAdd',
					component: gongjiaoxianluAdd
				},
				{
					path: 'gongjiaozhandian',
					component: gongjiaozhandianList
				},
				{
					path: 'gongjiaozhandianDetail',
					component: gongjiaozhandianDetail
				},
				{
					path: 'gongjiaozhandianAdd',
					component: gongjiaozhandianAdd
				},
				{
					path: 'gongjiaoxinxi',
					component: gongjiaoxinxiList
				},
				{
					path: 'gongjiaoxinxiDetail',
					component: gongjiaoxinxiDetail
				},
				{
					path: 'gongjiaoxinxiAdd',
					component: gongjiaoxinxiAdd
				},
				{
					path: 'zhoubianfuwu',
					component: zhoubianfuwuList
				},
				{
					path: 'zhoubianfuwuDetail',
					component: zhoubianfuwuDetail
				},
				{
					path: 'zhoubianfuwuAdd',
					component: zhoubianfuwuAdd
				},
				{
					path: 'gongjiaodongtai',
					component: gongjiaodongtaiList
				},
				{
					path: 'gongjiaodongtaiDetail',
					component: gongjiaodongtaiDetail
				},
				{
					path: 'gongjiaodongtaiAdd',
					component: gongjiaodongtaiAdd
				},
				{
					path: 'newstype',
					component: newstypeList
				},
				{
					path: 'newstypeDetail',
					component: newstypeDetail
				},
				{
					path: 'newstypeAdd',
					component: newstypeAdd
				},
				{
					path: 'aboutus',
					component: aboutusList
				},
				{
					path: 'aboutusDetail',
					component: aboutusDetail
				},
				{
					path: 'aboutusAdd',
					component: aboutusAdd
				},
				{
					path: 'systemintro',
					component: systemintroList
				},
				{
					path: 'systemintroDetail',
					component: systemintroDetail
				},
				{
					path: 'systemintroAdd',
					component: systemintroAdd
				},
				{
					path: 'discussgongjiaoxianlu',
					component: discussgongjiaoxianluList
				},
				{
					path: 'discussgongjiaoxianluDetail',
					component: discussgongjiaoxianluDetail
				},
				{
					path: 'discussgongjiaoxianluAdd',
					component: discussgongjiaoxianluAdd
				},
			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
