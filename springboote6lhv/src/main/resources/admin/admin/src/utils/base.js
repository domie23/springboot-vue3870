const base = {
    get() {
        return {
            url : "http://localhost:8080/springboote6lhv/",
            name: "springboote6lhv",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboote6lhv/front/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "疫苗接种管理系统"
        } 
    }
}
export default base
