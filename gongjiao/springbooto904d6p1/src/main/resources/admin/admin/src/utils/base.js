const base = {
    get() {
        return {
            url : "http://localhost:8080/springbooto904d6p1/",
            name: "springbooto904d6p1",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springbooto904d6p1/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "公交智能化系统"
        } 
    }
}
export default base
