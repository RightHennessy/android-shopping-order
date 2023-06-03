package com.shopping.repository

import com.shopping.domain.Product

interface ProductRepository {
    fun loadProducts(
        index: Pair<Int, Int>,
        onSuccess: (List<Product>) -> Unit,
        onFailure: (Exception) -> Unit
    )

    fun getProductById(
        index: Long,
        onSuccess: (Product) -> Unit,
        onFailure: (Exception) -> Unit
    )
}
