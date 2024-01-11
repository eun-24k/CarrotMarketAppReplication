package com.example.carrotmarketappreplication.data

import com.example.carrotmarketappreplication.R


object PostDatabase {

    var totalPostData: ArrayList<PostInfo> = arrayListOf()
    val imageArray: Array<Int> by lazy {
        arrayOf(
            R.drawable.sample1,
            R.drawable.sample2,
            R.drawable.sample3,
            R.drawable.sample4,
            R.drawable.sample5,
            R.drawable.sample6,
            R.drawable.sample7,
            R.drawable.sample8,
            R.drawable.sample9,
            R.drawable.sample10,
        )
    }
    val productArray: Array<String> by lazy {
        arrayOf(
            "산진 한달된 선풍기 팝니다\n",
            "김치냉장고\n",
            "샤넬 카드지갑\n",
            "금고\n",
            "갤럭시Z플립3 팝니다\n",
            "프라다 복조리백\n",
            "울산 동해오션뷰 60평 복층 펜트하우스 1일 숙박권 펜션 힐링 숙소 별장\n",
            "샤넬 탑핸들 가방\n",
            "4행정 엔진분무기 판매합니다.\n",
            "셀린느 버킷 가방\n"
        )
    }
    val infoArray: Array<String> by lazy {
        arrayOf(
            "이사가서 필요가 없어졌어요 급하게 내놓습니다\n",
            "이사로인해 내놔요\n",
            "고퀄지갑이구요\\n사용감이 있어서 싸게 내어둡니다\n",
            "금고\\n떼서 가져가야함\\n대우월드마크센텀\\n미국이주관계로 싸게 팝니다\n",
            "갤럭시 Z플립3 그린 팝니다\\n항시 케이스 씌워서 썻고 필름 한장챙겨드립니다\\n화면에 살짝 스크래치난거 말고 크게 이상은없습니다!\n",
            "까임 오염없고 상태 깨끗합니다\\n정품여부모름\n",
            "울산 동해바다뷰 60평 복층 펜트하우스 1일 숙박권\\n(에어컨이 없기에 낮은 가격으로 변경했으며 8월 초 가장 더운날 다녀가신 분 경우 시원했다고 잘 지내다 가셨습니다)\\n1. 인원: 6명 기준입니다. 1인 10,000원 추가요금\\n2. 장소: 북구 블루마시티, 32-33층\\n3. 취사도구, 침구류, 세면도구, 드라이기 2개, 선풍기 4대 구비\\n4. 예약방법: 예약금 50,000원 하시면 저희는 명함을 드리며 입실 오전 잔금 입금하시면 저희는 동.호수를 알려드리며 고객님은 예약자분 신분증 앞면 주민번호 뒷자리 가리시거나 지우시고 문자로 보내주시면 저희는 카드키를 우편함에 놓아 둡니다.\\n5. 33층 옥상 야외 테라스 있음, 가스버너 있음\\n6. 고기 굽기 가능\\n7. 입실 오후 3시, 오전 11시 퇴실, 정리, 정돈 , 밸브 잠금 부탁드립니다.\\n8. 층간소음 주의 부탁드립니다.\\n9. 방3개, 화장실3개, 비데 3개\\n10. 저희 집안이 쓰는 별장입니다.\n",
            "샤넬 트랜디 CC 탑핸들 스몰 램스킨 블랙 금장 플랩백 !\\n + \"\\n\" + \"색상 : 블랙\\n\" + \"사이즈 : 25.5cm * 17.5cm * 8cm\\n\" + \"구성 : 본품더스트\\n\" + \"\\n\" + \"급하게 돈이 필요해서 팝니다 ㅠ ㅠ\n",
            "3년전에 사서 한번 사용하고 그대로 둔 상태입니다. 요즘 사용은 안해봤습니다. 그래서 저렴하게 내 놓습니다. 중고라 반품은 어렵습니다.\\n\n",
            "22년 신세계 대전 구매입니당\\n + \"셀린느 버킷백\\n\" + \"구매해서 몇번사용했어요\\n\" + \"까짐 스크래치 없습니다.\\n\" + \"타지역에서 보내는거라 택배로 진행합니당!\"\n"
        )
    }
    private val usernameArray: Array<String> by lazy {
        arrayOf(
            "대현동\n",
            "안마담\n",
            "코코유\n",
            "Nicole\n",
            "절명\n",
            "미니멀하게\n",
            "굿리치\n",
            "난쉽\n",
            "알뜰한\n",
            "똑태현\n"
        )
    }
    private val priceArray: Array<Int> by lazy {
        arrayOf(1000, 20000, 10000, 10000, 150000, 50000, 150000, 180000, 30000, 190000)
    }

    private val addressArray: Array<String> by lazy {
        arrayOf(
            "서울 서대문구 창천동\n",
            "인천 계양구 귤현동\n",
            "수성구 범어동\n",
            "해운대구 우제2동\n",
            "연제구 연산제8동\n",
            "수원시 영통구 원천동\n",
            "남구 옥동\n",
            "동래구 온천제2동\n",
            "원주시 명륜2동\n",
            "중구 동화동\n",
        )
    }

    private val likesArray: Array<Int> by lazy {
        arrayOf(13, 8, 23, 14, 22, 25, 142, 31, 7, 40)
    }
    private val commentsArray: Array<Int> by lazy {
        arrayOf(25, 28, 5, 17, 9, 16, 54, 7, 28, 6)
    }

    fun formDummyData() {
        for (i in 0 until 10) {
            val newPost = PostInfo(
                i + 1,
                imageArray[i],
                productArray[i],
                infoArray[i],
                usernameArray[i],
                priceArray[i],
                addressArray[i],
                likesArray[i],
                commentsArray[i]
            )
            addPost(newPost)
        }
    }
//    /**
//     * Reads the value from the cell at the first row and first column of worksheet.
//     */
//    fun readFromExcelFile(filepath: String) {
//        val inputStream = FileInputStream(filepath)
//        //Instantiate Excel workbook using existing file:
//        var xlWb = WorkbookFactory.create(inputStream)
//        // Data Formatter class allows you to format the cell type data that is instream
//        val fmt = DataFormatter()
//
//        //Row index specifies the row in the worksheet (starting at 0):
//        val rowNumber = 1
//        //Cell index specifies the column within the chosen row (starting at 0):
//        val columnNumber = 0
//
//        //Get reference to first sheet:
//        val xlWs = xlWb.getSheetAt(0)
//        println(xlWs.getRow(rowNumber).getCell(columnNumber))


//        // Adds the dummy data into the database
//        for (row in 1..10){
//            var dummyPost = PostInfo(fmt.formatCellValue(xlWs.getRow(row).getCell(0)).toInt(),
//                imageArray[fmt.formatCellValue(xlWs.getRow(row).getCell(0)).toInt()-1],
//                fmt.formatCellValue(xlWs.getRow(row).getCell(2)),
//                fmt.formatCellValue(xlWs.getRow(row).getCell(3)),
//                fmt.formatCellValue(xlWs.getRow(row).getCell(4)),
//                fmt.formatCellValue(xlWs.getRow(row).getCell(5)).toInt(),
//                fmt.formatCellValue(xlWs.getRow(row).getCell(6)),
//                fmt.formatCellValue(xlWs.getRow(row).getCell(7)).toInt(),
//                fmt.formatCellValue(xlWs.getRow(row).getCell(8)).toInt()
//                )
//            addPost(dummyPost)
//        }
//    }

//    fun importDummyData() {
//        val doc = context.assets.open("dummyData.xlsx").use { xmlInputStream ->
//            DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(xmlInputStream)
//        }
//        val filepath = "./dummyData.xlsx"
//        readFromExcelFile(filepath)
//    }

    // 포스팅을 저장하는 함수
    fun addPost(user: PostInfo) {
        totalPostData.add(user)
    }

    // 포스팅 정보를 가져오는 함수
    fun getTotalPostInfo(): ArrayList<PostInfo> {
        return totalPostData
    }

    // 닉네임을 가지고 해당 포스팅 정보 가져오는 함수
    fun getPost(username: String): PostInfo {
        return totalPostData.find { it.userName == username }!!
    }

    // 포스팅 정보를 수정하는 함수
    fun editPostData(user: PostInfo) {
        getPost(user.userName).let {
            it.image = user.image
            it.product = user.product
            it.info = user.info
            it.price = user.price
            it.address = user.address
            it.likes = user.likes
            it.comments = user.comments
        }
    }
}