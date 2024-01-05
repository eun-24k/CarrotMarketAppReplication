package com.example.carrotmarketappreplication.data

import org.apache.poi.ss.usermodel.DataFormatter
import org.apache.poi.ss.usermodel.WorkbookFactory
import java.io.FileInputStream

object PostDatabase {

    var totalPostData: ArrayList<PostInfo> = arrayListOf()

    /**
     * Reads the value from the cell at the first row and first column of worksheet.
     */
    fun readFromExcelFile(filepath: String) {
        val inputStream = FileInputStream(filepath)
        //Instantiate Excel workbook using existing file:
        var xlWb = WorkbookFactory.create(inputStream)
        // Data Formatter class allows you to format the cell type data that is instream
        val fmt = DataFormatter()

        //Row index specifies the row in the worksheet (starting at 0):
        val rowNumber = 1
        //Cell index specifies the column within the chosen row (starting at 0):
        val columnNumber = 0

        //Get reference to first sheet:
        val xlWs = xlWb.getSheetAt(0)
        println(xlWs.getRow(rowNumber).getCell(columnNumber))

        // Adds the dummy data into the database
        for (row in 1..10){
            var dummyPost = PostInfo(fmt.formatCellValue(xlWs.getRow(row).getCell(0)).toInt(),
                fmt.formatCellValue(xlWs.getRow(row).getCell(1)),
                fmt.formatCellValue(xlWs.getRow(row).getCell(2)),
                fmt.formatCellValue(xlWs.getRow(row).getCell(3)),
                fmt.formatCellValue(xlWs.getRow(row).getCell(4)),
                fmt.formatCellValue(xlWs.getRow(row).getCell(5)).toInt(),
                fmt.formatCellValue(xlWs.getRow(row).getCell(6)),
                fmt.formatCellValue(xlWs.getRow(row).getCell(7)).toInt(),
                fmt.formatCellValue(xlWs.getRow(row).getCell(8)).toInt()
                )
            addUser(dummyPost)
        }
    }

    fun main(args: Array<String>) {
        val filepath = "./dummyData.xlsx"
        readFromExcelFile(filepath)
    }

    // 포스팅을 저장하는 함수
    fun addUser(user: PostInfo) {
        totalPostData.add(user)
    }

    // 포스팅 정보를 가져오는 함수
    fun getTotalUser(): ArrayList<PostInfo> {
        return totalPostData
    }

    // 닉네임을 가지고 해당 포스팅 정보 가져오는 함수
    fun getUser(username: String): PostInfo? {
        return totalPostData.find { it.userName == username }
    }

    // 포스팅 정보를 수정하는 함수
    fun editUserData(user: PostInfo) {
        getUser(user.userName)?.let {
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