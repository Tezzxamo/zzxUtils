# -*- coding: utf-8 -*-

import pandas as pd

if __name__ == '__main__':
    df = pd.read_csv('../data/market.csv')

    # 使price变量值呈现条形图
    df.style.bar("price", vmin=0)

    # 使price变量呈现背景颜色的梯度变化，以呈现映射的数值大小（越深标识数值越大）
    df.style.background_gradient("Greens", subset="price")

    # 使缺失值高亮
    df.style.highlight_null()

