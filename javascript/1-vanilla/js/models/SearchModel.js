const data = [
    {
        id: 1,
        name: '[키친르쎌] 홈메이드 칠리소스 포크립 650g',
        image: 'https://cdn.dominos.co.kr/admin/upload/goods/20180827_pWzUcM5T.jpg'
    },
    {
        id: 2,
        name: '[키친르쎌] 이탈리아 파티 세트 3~4인분',
        image: 'http://recipe1.ezmember.co.kr/cache/recipe/2015/06/22/521aa2e376190abab5c674de549f16cb1.jpg'
    }
]

export default {
    list(query) {
        return new Promise(res => {
            setTimeout(() => {
                res(data)
            }, 200);
        })
    }
}